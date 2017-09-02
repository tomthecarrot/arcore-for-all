package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder.SetMultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class ClassPath
{
  private static final String CLASS_FILE_NAME_EXTENSION = ".class";
  private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
  private static final Predicate<ClassInfo> IS_TOP_LEVEL;
  private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
  private final ImmutableSet<ResourceInfo> resources;
  
  static
  {
    IS_TOP_LEVEL = new Predicate()
    {
      public boolean apply(ClassPath.ClassInfo paramAnonymousClassInfo)
      {
        return ClassPath.ClassInfo.access$000(paramAnonymousClassInfo).indexOf('$') == -1;
      }
    };
  }
  
  private ClassPath(ImmutableSet<ResourceInfo> paramImmutableSet)
  {
    this.resources = paramImmutableSet;
  }
  
  public static ClassPath from(ClassLoader paramClassLoader)
    throws IOException
  {
    DefaultScanner localDefaultScanner = new DefaultScanner();
    localDefaultScanner.scan(paramClassLoader);
    return new ClassPath(localDefaultScanner.getResources());
  }
  
  @VisibleForTesting
  static String getClassName(String paramString)
  {
    return paramString.substring(0, paramString.length() - ".class".length()).replace('/', '.');
  }
  
  public ImmutableSet<ClassInfo> getAllClasses()
  {
    return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
  }
  
  public ImmutableSet<ResourceInfo> getResources()
  {
    return this.resources;
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClasses()
  {
    return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClasses(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    ImmutableSet.Builder localBuilder = ImmutableSet.builder();
    Iterator localIterator = getTopLevelClasses().iterator();
    while (localIterator.hasNext())
    {
      ClassInfo localClassInfo = (ClassInfo)localIterator.next();
      if (localClassInfo.getPackageName().equals(paramString)) {
        localBuilder.add(localClassInfo);
      }
    }
    return localBuilder.build();
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    paramString = paramString + '.';
    ImmutableSet.Builder localBuilder = ImmutableSet.builder();
    Iterator localIterator = getTopLevelClasses().iterator();
    while (localIterator.hasNext())
    {
      ClassInfo localClassInfo = (ClassInfo)localIterator.next();
      if (localClassInfo.getName().startsWith(paramString)) {
        localBuilder.add(localClassInfo);
      }
    }
    return localBuilder.build();
  }
  
  @Beta
  public static final class ClassInfo
    extends ClassPath.ResourceInfo
  {
    private final String className;
    
    ClassInfo(String paramString, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.className = ClassPath.getClassName(paramString);
    }
    
    public String getName()
    {
      return this.className;
    }
    
    public String getPackageName()
    {
      return Reflection.getPackageName(this.className);
    }
    
    public String getSimpleName()
    {
      int i = this.className.lastIndexOf('$');
      if (i != -1)
      {
        str = this.className.substring(i + 1);
        return CharMatcher.DIGIT.trimLeadingFrom(str);
      }
      String str = getPackageName();
      if (str.isEmpty()) {
        return this.className;
      }
      return this.className.substring(str.length() + 1);
    }
    
    public Class<?> load()
    {
      try
      {
        Class localClass = this.loader.loadClass(this.className);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new IllegalStateException(localClassNotFoundException);
      }
    }
    
    public String toString()
    {
      return this.className;
    }
  }
  
  @VisibleForTesting
  static final class DefaultScanner
    extends ClassPath.Scanner
  {
    private final SetMultimap<ClassLoader, String> resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();
    
    private void scanDirectory(File paramFile, ClassLoader paramClassLoader, String paramString)
      throws IOException
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
      {
        ClassPath.logger.warning("Cannot read directory " + paramFile);
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      label45:
      String str;
      if (i < j)
      {
        paramFile = arrayOfFile[i];
        str = paramFile.getName();
        if (!paramFile.isDirectory()) {
          break label110;
        }
        scanDirectory(paramFile, paramClassLoader, paramString + str + "/");
      }
      for (;;)
      {
        i += 1;
        break label45;
        break;
        label110:
        paramFile = paramString + str;
        if (!paramFile.equals("META-INF/MANIFEST.MF")) {
          this.resources.get(paramClassLoader).add(paramFile);
        }
      }
    }
    
    ImmutableSet<ClassPath.ResourceInfo> getResources()
    {
      ImmutableSet.Builder localBuilder = ImmutableSet.builder();
      Iterator localIterator = this.resources.entries().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.add(ClassPath.ResourceInfo.of((String)localEntry.getValue(), (ClassLoader)localEntry.getKey()));
      }
      return localBuilder.build();
    }
    
    protected void scanDirectory(ClassLoader paramClassLoader, File paramFile)
      throws IOException
    {
      scanDirectory(paramFile, paramClassLoader, "");
    }
    
    protected void scanJarFile(ClassLoader paramClassLoader, JarFile paramJarFile)
    {
      paramJarFile = paramJarFile.entries();
      while (paramJarFile.hasMoreElements())
      {
        JarEntry localJarEntry = (JarEntry)paramJarFile.nextElement();
        if ((!localJarEntry.isDirectory()) && (!localJarEntry.getName().equals("META-INF/MANIFEST.MF"))) {
          this.resources.get(paramClassLoader).add(localJarEntry.getName());
        }
      }
    }
  }
  
  @Beta
  public static class ResourceInfo
  {
    final ClassLoader loader;
    private final String resourceName;
    
    ResourceInfo(String paramString, ClassLoader paramClassLoader)
    {
      this.resourceName = ((String)Preconditions.checkNotNull(paramString));
      this.loader = ((ClassLoader)Preconditions.checkNotNull(paramClassLoader));
    }
    
    static ResourceInfo of(String paramString, ClassLoader paramClassLoader)
    {
      if (paramString.endsWith(".class")) {
        return new ClassPath.ClassInfo(paramString, paramClassLoader);
      }
      return new ResourceInfo(paramString, paramClassLoader);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof ResourceInfo))
      {
        paramObject = (ResourceInfo)paramObject;
        bool1 = bool2;
        if (this.resourceName.equals(((ResourceInfo)paramObject).resourceName))
        {
          bool1 = bool2;
          if (this.loader == ((ResourceInfo)paramObject).loader) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public final String getResourceName()
    {
      return this.resourceName;
    }
    
    public int hashCode()
    {
      return this.resourceName.hashCode();
    }
    
    public String toString()
    {
      return this.resourceName;
    }
    
    public final URL url()
      throws NoSuchElementException
    {
      URL localURL = this.loader.getResource(this.resourceName);
      if (localURL == null) {
        throw new NoSuchElementException(this.resourceName);
      }
      return localURL;
    }
  }
  
  static abstract class Scanner
  {
    private final Set<File> scannedUris = Sets.newHashSet();
    
    @VisibleForTesting
    static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader paramClassLoader)
    {
      LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
      Object localObject = paramClassLoader.getParent();
      if (localObject != null) {
        localLinkedHashMap.putAll(getClassPathEntries((ClassLoader)localObject));
      }
      if ((paramClassLoader instanceof URLClassLoader))
      {
        localObject = ((URLClassLoader)paramClassLoader).getURLs();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = localObject[i];
          if (localFile.getProtocol().equals("file"))
          {
            localFile = new File(localFile.getFile());
            if (!localLinkedHashMap.containsKey(localFile)) {
              localLinkedHashMap.put(localFile, paramClassLoader);
            }
          }
          i += 1;
        }
      }
      return ImmutableMap.copyOf(localLinkedHashMap);
    }
    
    @VisibleForTesting
    static URL getClassPathEntry(File paramFile, String paramString)
      throws MalformedURLException
    {
      return new URL(paramFile.toURI().toURL(), paramString);
    }
    
    @VisibleForTesting
    static ImmutableSet<File> getClassPathFromManifest(File paramFile, @Nullable Manifest paramManifest)
    {
      if (paramManifest == null) {
        return ImmutableSet.of();
      }
      ImmutableSet.Builder localBuilder = ImmutableSet.builder();
      paramManifest = paramManifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
      if (paramManifest != null)
      {
        paramManifest = ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(paramManifest).iterator();
        while (paramManifest.hasNext())
        {
          String str = (String)paramManifest.next();
          try
          {
            URL localURL = getClassPathEntry(paramFile, str);
            if (localURL.getProtocol().equals("file")) {
              localBuilder.add(new File(localURL.getFile()));
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ClassPath.logger.warning("Invalid Class-Path entry: " + str);
          }
        }
      }
      return localBuilder.build();
    }
    
    private void scanFrom(File paramFile, ClassLoader paramClassLoader)
      throws IOException
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isDirectory())
      {
        scanDirectory(paramClassLoader, paramFile);
        return;
      }
      scanJar(paramFile, paramClassLoader);
    }
    
    /* Error */
    private void scanJar(File paramFile, ClassLoader paramClassLoader)
      throws IOException
    {
      // Byte code:
      //   0: new 219	java/util/jar/JarFile
      //   3: dup
      //   4: aload_1
      //   5: invokespecial 222	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
      //   8: astore_3
      //   9: aload_1
      //   10: aload_3
      //   11: invokevirtual 226	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
      //   14: invokestatic 228	com/google/common/reflect/ClassPath$Scanner:getClassPathFromManifest	(Ljava/io/File;Ljava/util/jar/Manifest;)Lcom/google/common/collect/ImmutableSet;
      //   17: invokevirtual 229	com/google/common/collect/ImmutableSet:iterator	()Ljava/util/Iterator;
      //   20: astore_1
      //   21: aload_1
      //   22: invokeinterface 164 1 0
      //   27: ifeq +29 -> 56
      //   30: aload_0
      //   31: aload_1
      //   32: invokeinterface 168 1 0
      //   37: checkcast 68	java/io/File
      //   40: aload_2
      //   41: invokevirtual 232	com/google/common/reflect/ClassPath$Scanner:scan	(Ljava/io/File;Ljava/lang/ClassLoader;)V
      //   44: goto -23 -> 21
      //   47: astore_1
      //   48: aload_3
      //   49: invokevirtual 235	java/util/jar/JarFile:close	()V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: return
      //   56: aload_0
      //   57: aload_2
      //   58: aload_3
      //   59: invokevirtual 239	com/google/common/reflect/ClassPath$Scanner:scanJarFile	(Ljava/lang/ClassLoader;Ljava/util/jar/JarFile;)V
      //   62: aload_3
      //   63: invokevirtual 235	java/util/jar/JarFile:close	()V
      //   66: return
      //   67: astore_1
      //   68: return
      //   69: astore_2
      //   70: goto -18 -> 52
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	Scanner
      //   0	73	1	paramFile	File
      //   0	73	2	paramClassLoader	ClassLoader
      //   8	55	3	localJarFile	JarFile
      // Exception table:
      //   from	to	target	type
      //   9	21	47	finally
      //   21	44	47	finally
      //   56	62	47	finally
      //   0	9	54	java/io/IOException
      //   62	66	67	java/io/IOException
      //   48	52	69	java/io/IOException
    }
    
    @VisibleForTesting
    final void scan(File paramFile, ClassLoader paramClassLoader)
      throws IOException
    {
      if (this.scannedUris.add(paramFile.getCanonicalFile())) {
        scanFrom(paramFile, paramClassLoader);
      }
    }
    
    public final void scan(ClassLoader paramClassLoader)
      throws IOException
    {
      paramClassLoader = getClassPathEntries(paramClassLoader).entrySet().iterator();
      while (paramClassLoader.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramClassLoader.next();
        scan((File)localEntry.getKey(), (ClassLoader)localEntry.getValue());
      }
    }
    
    protected abstract void scanDirectory(ClassLoader paramClassLoader, File paramFile)
      throws IOException;
    
    protected abstract void scanJarFile(ClassLoader paramClassLoader, JarFile paramJarFile)
      throws IOException;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/reflect/ClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */