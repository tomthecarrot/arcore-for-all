package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.Nullable;

@Beta
public final class InetAddresses
{
  private static final Inet4Address ANY4 = (Inet4Address)forString("0.0.0.0");
  private static final int IPV4_PART_COUNT = 4;
  private static final int IPV6_PART_COUNT = 8;
  private static final Inet4Address LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
  
  private static InetAddress bytesToInetAddress(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnknownHostException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static int coerceToInteger(InetAddress paramInetAddress)
  {
    return ByteStreams.newDataInput(getCoercedIPv4Address(paramInetAddress).getAddress()).readInt();
  }
  
  private static void compressLongestRunOfZeroes(int[] paramArrayOfInt)
  {
    int m = -1;
    int k = -1;
    int j = -1;
    int i = 0;
    if (i < paramArrayOfInt.length + 1)
    {
      int i1;
      int i2;
      int n;
      if ((i < paramArrayOfInt.length) && (paramArrayOfInt[i] == 0))
      {
        i1 = k;
        i2 = m;
        n = j;
        if (j < 0)
        {
          n = i;
          i2 = m;
          i1 = k;
        }
      }
      for (;;)
      {
        i += 1;
        k = i1;
        m = i2;
        j = n;
        break;
        i1 = k;
        i2 = m;
        n = j;
        if (j >= 0)
        {
          i1 = i - j;
          n = k;
          if (i1 > k)
          {
            n = i1;
            m = j;
          }
          j = -1;
          i1 = n;
          i2 = m;
          n = j;
        }
      }
    }
    if (k >= 2) {
      Arrays.fill(paramArrayOfInt, m, m + k, -1);
    }
  }
  
  private static String convertDottedQuadToHex(String paramString)
  {
    int i = paramString.lastIndexOf(':');
    String str = paramString.substring(0, i + 1);
    Object localObject = textToNumericFormatV4(paramString.substring(i + 1));
    if (localObject == null) {
      return null;
    }
    paramString = Integer.toHexString((localObject[0] & 0xFF) << 8 | localObject[1] & 0xFF);
    localObject = Integer.toHexString((localObject[2] & 0xFF) << 8 | localObject[3] & 0xFF);
    return str + paramString + ":" + (String)localObject;
  }
  
  public static InetAddress decrement(InetAddress paramInetAddress)
  {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while ((i >= 0) && (arrayOfByte[i] == 0))
    {
      arrayOfByte[i] = -1;
      i -= 1;
    }
    if (i >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Decrementing %s would wrap.", new Object[] { paramInetAddress });
      arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
      return bytesToInetAddress(arrayOfByte);
    }
  }
  
  public static InetAddress forString(String paramString)
  {
    byte[] arrayOfByte = ipStringToBytes(paramString);
    if (arrayOfByte == null) {
      throw formatIllegalArgumentException("'%s' is not an IP string literal.", new Object[] { paramString });
    }
    return bytesToInetAddress(arrayOfByte);
  }
  
  public static InetAddress forUriString(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    Object localObject;
    if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
      localObject = paramString.substring(1, paramString.length() - 1);
    }
    for (int i = 16;; i = 4)
    {
      localObject = ipStringToBytes((String)localObject);
      if ((localObject != null) && (localObject.length == i)) {
        break;
      }
      throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", new Object[] { paramString });
      localObject = paramString;
    }
    return bytesToInetAddress((byte[])localObject);
  }
  
  private static IllegalArgumentException formatIllegalArgumentException(String paramString, Object... paramVarArgs)
  {
    return new IllegalArgumentException(String.format(Locale.ROOT, paramString, paramVarArgs));
  }
  
  public static Inet4Address fromInteger(int paramInt)
  {
    return getInet4Address(Ints.toByteArray(paramInt));
  }
  
  public static InetAddress fromLittleEndianByteArray(byte[] paramArrayOfByte)
    throws UnknownHostException
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = paramArrayOfByte[(paramArrayOfByte.length - i - 1)];
      i += 1;
    }
    return InetAddress.getByAddress(arrayOfByte);
  }
  
  public static Inet4Address get6to4IPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(is6to4Address(paramInet6Address), "Address '%s' is not a 6to4 address.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 2, 6));
  }
  
  public static Inet4Address getCoercedIPv4Address(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return (Inet4Address)paramInetAddress;
    }
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int k = 1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i < 15)
      {
        if (arrayOfByte[i] != 0) {
          j = 0;
        }
      }
      else
      {
        if ((j == 0) || (arrayOfByte[15] != 1)) {
          break;
        }
        return LOOPBACK4;
      }
      i += 1;
    }
    if ((j != 0) && (arrayOfByte[15] == 0)) {
      return ANY4;
    }
    paramInetAddress = (Inet6Address)paramInetAddress;
    if (hasEmbeddedIPv4ClientAddress(paramInetAddress)) {}
    for (long l = getEmbeddedIPv4ClientAddress(paramInetAddress).hashCode();; l = ByteBuffer.wrap(paramInetAddress.getAddress(), 0, 8).getLong())
    {
      j = Hashing.murmur3_32().hashLong(l).asInt() | 0xE0000000;
      i = j;
      if (j == -1) {
        i = -2;
      }
      return getInet4Address(Ints.toByteArray(i));
    }
  }
  
  public static Inet4Address getCompatIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isCompatIPv4Address(paramInet6Address), "Address '%s' is not IPv4-compatible.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    if (isCompatIPv4Address(paramInet6Address)) {
      return getCompatIPv4Address(paramInet6Address);
    }
    if (is6to4Address(paramInet6Address)) {
      return get6to4IPv4Address(paramInet6Address);
    }
    if (isTeredoAddress(paramInet6Address)) {
      return getTeredoInfo(paramInet6Address).getClient();
    }
    throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", new Object[] { toAddrString(paramInet6Address) });
  }
  
  private static Inet4Address getInet4Address(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Byte array has invalid length for an IPv4 address: %s != 4.", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      return (Inet4Address)bytesToInetAddress(paramArrayOfByte);
    }
  }
  
  public static Inet4Address getIsatapIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isIsatapAddress(paramInet6Address), "Address '%s' is not an ISATAP address.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static TeredoInfo getTeredoInfo(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isTeredoAddress(paramInet6Address), "Address '%s' is not a Teredo address.", new Object[] { toAddrString(paramInet6Address) });
    byte[] arrayOfByte = paramInet6Address.getAddress();
    paramInet6Address = getInet4Address(Arrays.copyOfRange(arrayOfByte, 4, 8));
    int j = ByteStreams.newDataInput(arrayOfByte, 8).readShort();
    int k = ByteStreams.newDataInput(arrayOfByte, 10).readShort();
    arrayOfByte = Arrays.copyOfRange(arrayOfByte, 12, 16);
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ 0xFFFFFFFF));
      i += 1;
    }
    return new TeredoInfo(paramInet6Address, getInet4Address(arrayOfByte), (k ^ 0xFFFFFFFF) & 0xFFFF, j & 0xFFFF);
  }
  
  public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    return (isCompatIPv4Address(paramInet6Address)) || (is6to4Address(paramInet6Address)) || (isTeredoAddress(paramInet6Address));
  }
  
  private static String hextetsToIPv6String(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(39);
    int k = 0;
    int j = 0;
    if (j < paramArrayOfInt.length)
    {
      int i;
      if (paramArrayOfInt[j] >= 0)
      {
        i = 1;
        label29:
        if (i == 0) {
          break label71;
        }
        if (k != 0) {
          localStringBuilder.append(':');
        }
        localStringBuilder.append(Integer.toHexString(paramArrayOfInt[j]));
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = 0;
        break label29;
        label71:
        if ((j == 0) || (k != 0)) {
          localStringBuilder.append("::");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress increment(InetAddress paramInetAddress)
  {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while ((i >= 0) && (arrayOfByte[i] == -1))
    {
      arrayOfByte[i] = 0;
      i -= 1;
    }
    if (i >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Incrementing %s would wrap.", new Object[] { paramInetAddress });
      arrayOfByte[i] = ((byte)(arrayOfByte[i] + 1));
      return bytesToInetAddress(arrayOfByte);
    }
  }
  
  private static byte[] ipStringToBytes(String paramString)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    char c;
    for (;;)
    {
      if (i < paramString.length())
      {
        c = paramString.charAt(i);
        if (c == '.')
        {
          j = 1;
          i += 1;
        }
        else if (c == ':')
        {
          if (j == 0) {
            break;
          }
        }
      }
    }
    label89:
    label95:
    do
    {
      String str;
      do
      {
        return null;
        k = 1;
        break;
        if (Character.digit(c, 16) != -1) {
          break;
        }
        return null;
        if (k == 0) {
          break label95;
        }
        str = paramString;
        if (j == 0) {
          break label89;
        }
        str = convertDottedQuadToHex(paramString);
      } while (str == null);
      return textToNumericFormatV6(str);
    } while (j == 0);
    return textToNumericFormatV4(paramString);
  }
  
  public static boolean is6to4Address(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 2);
  }
  
  public static boolean isCompatIPv4Address(Inet6Address paramInet6Address)
  {
    if (!paramInet6Address.isIPv4CompatibleAddress()) {}
    do
    {
      return false;
      paramInet6Address = paramInet6Address.getAddress();
    } while ((paramInet6Address[12] == 0) && (paramInet6Address[13] == 0) && (paramInet6Address[14] == 0) && ((paramInet6Address[15] == 0) || (paramInet6Address[15] == 1)));
    return true;
  }
  
  public static boolean isInetAddress(String paramString)
  {
    return ipStringToBytes(paramString) != null;
  }
  
  public static boolean isIsatapAddress(Inet6Address paramInet6Address)
  {
    if (isTeredoAddress(paramInet6Address)) {}
    do
    {
      return false;
      paramInet6Address = paramInet6Address.getAddress();
    } while (((paramInet6Address[8] | 0x3) != 3) || (paramInet6Address[9] != 0) || (paramInet6Address[10] != 94) || (paramInet6Address[11] != -2));
    return true;
  }
  
  public static boolean isMappedIPv4Address(String paramString)
  {
    paramString = ipStringToBytes(paramString);
    if ((paramString != null) && (paramString.length == 16)) {
      i = 0;
    }
    while (i < 10)
    {
      if (paramString[i] != 0) {
        return false;
      }
      i += 1;
    }
    int i = 10;
    for (;;)
    {
      if (i >= 12) {
        break label62;
      }
      if (paramString[i] != -1) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public static boolean isMaximum(InetAddress paramInetAddress)
  {
    paramInetAddress = paramInetAddress.getAddress();
    int i = 0;
    while (i < paramInetAddress.length)
    {
      if (paramInetAddress[i] != -1) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isTeredoAddress(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 1) && (paramInet6Address[2] == 0) && (paramInet6Address[3] == 0);
  }
  
  public static boolean isUriInetAddress(String paramString)
  {
    try
    {
      forUriString(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString) {}
    return false;
  }
  
  private static short parseHextet(String paramString)
  {
    int i = Integer.parseInt(paramString, 16);
    if (i > 65535) {
      throw new NumberFormatException();
    }
    return (short)i;
  }
  
  private static byte parseOctet(String paramString)
  {
    int i = Integer.parseInt(paramString);
    if ((i > 255) || ((paramString.startsWith("0")) && (paramString.length() > 1))) {
      throw new NumberFormatException();
    }
    return (byte)i;
  }
  
  private static byte[] textToNumericFormatV4(String paramString)
  {
    String[] arrayOfString = paramString.split("\\.", 5);
    if (arrayOfString.length != 4) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      byte[] arrayOfByte = new byte[4];
      int i = 0;
      paramString = arrayOfByte;
      try
      {
        if (i < arrayOfByte.length)
        {
          arrayOfByte[i] = parseOctet(arrayOfString[i]);
          i += 1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return null;
  }
  
  private static byte[] textToNumericFormatV6(String paramString)
  {
    paramString = paramString.split(":", 10);
    if ((paramString.length < 3) || (paramString.length > 9)) {}
    int i;
    int k;
    label62:
    int m;
    do
    {
      do
      {
        int n;
        do
        {
          return null;
          j = -1;
          i = 1;
          for (;;)
          {
            if (i >= paramString.length - 1) {
              break label62;
            }
            k = j;
            if (paramString[i].length() == 0)
            {
              if (j >= 0) {
                break;
              }
              k = i;
            }
            i += 1;
            j = k;
          }
          if (j < 0) {
            break label176;
          }
          i = j;
          n = paramString.length - j - 1;
          k = i;
          if (paramString[0].length() != 0) {
            break;
          }
          k = i - 1;
        } while (k != 0);
        m = k;
        i = n;
        if (paramString[(paramString.length - 1)].length() != 0) {
          break;
        }
        i = n - 1;
      } while (i != 0);
      m = k;
      k = 8 - (m + i);
      if (j < 0) {
        break label185;
      }
    } while (k < 1);
    ByteBuffer localByteBuffer;
    label176:
    label185:
    while (k == 0)
    {
      localByteBuffer = ByteBuffer.allocate(16);
      j = 0;
      for (;;)
      {
        if (j >= m) {
          break label191;
        }
        try
        {
          localByteBuffer.putShort(parseHextet(paramString[j]));
          j += 1;
        }
        catch (NumberFormatException paramString)
        {
          return null;
        }
      }
      m = paramString.length;
      i = 0;
      break;
    }
    return null;
    label191:
    int j = 0;
    while (j < k)
    {
      localByteBuffer.putShort((short)0);
      j += 1;
    }
    for (;;)
    {
      if (i > 0)
      {
        localByteBuffer.putShort(parseHextet(paramString[(paramString.length - i)]));
        i -= 1;
      }
      else
      {
        return localByteBuffer.array();
      }
    }
  }
  
  public static String toAddrString(InetAddress paramInetAddress)
  {
    Preconditions.checkNotNull(paramInetAddress);
    if ((paramInetAddress instanceof Inet4Address)) {
      return paramInetAddress.getHostAddress();
    }
    Preconditions.checkArgument(paramInetAddress instanceof Inet6Address);
    paramInetAddress = paramInetAddress.getAddress();
    int[] arrayOfInt = new int[8];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = Ints.fromBytes(0, 0, paramInetAddress[(i * 2)], paramInetAddress[(i * 2 + 1)]);
      i += 1;
    }
    compressLongestRunOfZeroes(arrayOfInt);
    return hextetsToIPv6String(arrayOfInt);
  }
  
  public static String toUriString(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet6Address)) {
      return "[" + toAddrString(paramInetAddress) + "]";
    }
    return toAddrString(paramInetAddress);
  }
  
  @Beta
  public static final class TeredoInfo
  {
    private final Inet4Address client;
    private final int flags;
    private final int port;
    private final Inet4Address server;
    
    public TeredoInfo(@Nullable Inet4Address paramInet4Address1, @Nullable Inet4Address paramInet4Address2, int paramInt1, int paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 <= 65535))
      {
        bool = true;
        Preconditions.checkArgument(bool, "port '%s' is out of range (0 <= port <= 0xffff)", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt2 < 0) || (paramInt2 > 65535)) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "flags '%s' is out of range (0 <= flags <= 0xffff)", new Object[] { Integer.valueOf(paramInt2) });
        this.server = ((Inet4Address)MoreObjects.firstNonNull(paramInet4Address1, InetAddresses.ANY4));
        this.client = ((Inet4Address)MoreObjects.firstNonNull(paramInet4Address2, InetAddresses.ANY4));
        this.port = paramInt1;
        this.flags = paramInt2;
        return;
        bool = false;
        break;
      }
    }
    
    public Inet4Address getClient()
    {
      return this.client;
    }
    
    public int getFlags()
    {
      return this.flags;
    }
    
    public int getPort()
    {
      return this.port;
    }
    
    public Inet4Address getServer()
    {
      return this.server;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/net/InetAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */