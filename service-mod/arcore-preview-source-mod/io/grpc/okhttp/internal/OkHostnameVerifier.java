package io.grpc.okhttp.internal;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      Iterator localIterator = paramX509Certificate.iterator();
      for (;;)
      {
        paramX509Certificate = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramX509Certificate = (List)localIterator.next();
        if ((paramX509Certificate != null) && (paramX509Certificate.size() >= 2))
        {
          Integer localInteger = (Integer)paramX509Certificate.get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            paramX509Certificate = (String)paramX509Certificate.get(1);
            if (paramX509Certificate != null) {
              localArrayList.add(paramX509Certificate);
            }
          }
        }
      }
      return paramX509Certificate;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      paramX509Certificate = Collections.emptyList();
    }
  }
  
  static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
  
  private boolean verifyHostName(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith(".."))) {}
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")));
          str = paramString1;
          if (!paramString1.endsWith(".")) {
            str = paramString1 + '.';
          }
          paramString1 = paramString2;
          if (!paramString2.endsWith(".")) {
            paramString1 = paramString2 + '.';
          }
          paramString1 = paramString1.toLowerCase(Locale.US);
          if (!paramString1.contains("*")) {
            return str.equals(paramString1);
          }
        } while ((!paramString1.startsWith("*.")) || (paramString1.indexOf('*', 1) != -1) || (str.length() < paramString1.length()) || ("*.".equals(paramString1)));
        paramString1 = paramString1.substring(1);
      } while (!str.endsWith(paramString1));
      i = str.length() - paramString1.length();
    } while ((i > 0) && (str.lastIndexOf('.', i - 1) != -1));
    return true;
  }
  
  private boolean verifyHostName(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    int j = 0;
    List localList = getSubjectAltNames(paramX509Certificate, 2);
    int i = 0;
    int k = localList.size();
    while (i < k)
    {
      j = 1;
      if (verifyHostName(paramString, (String)localList.get(i))) {
        return true;
      }
      i += 1;
    }
    if (j == 0)
    {
      paramX509Certificate = new DistinguishedNameParser(paramX509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
      if (paramX509Certificate != null) {
        return verifyHostName(paramString, paramX509Certificate);
      }
    }
    return false;
  }
  
  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 7);
    int i = 0;
    int j = paramX509Certificate.size();
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (verifyAsIpAddress(paramString)) {
      return verifyIpAddress(paramString, paramX509Certificate);
    }
    return verifyHostName(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/internal/OkHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */