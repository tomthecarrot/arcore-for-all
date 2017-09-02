package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8
{
  private static final long ASCII_MASK_LONG = -9187201950435737472L;
  public static final int COMPLETE = 0;
  public static final int MALFORMED = -1;
  static final int MAX_BYTES_PER_CHAR = 3;
  private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
  private static final Processor processor;
  
  static
  {
    if (UnsafeProcessor.isAvailable()) {}
    for (Object localObject = new UnsafeProcessor();; localObject = new SafeProcessor())
    {
      processor = (Processor)localObject;
      return;
    }
  }
  
  static int encode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return processor.encodeUtf8(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    processor.encodeUtf8(paramCharSequence, paramByteBuffer);
  }
  
  static int encodedLength(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = n;
    int j = 0;
    int k;
    int i;
    for (;;)
    {
      k = j;
      i = m;
      if (j >= n) {
        break;
      }
      k = j;
      i = m;
      if (paramCharSequence.charAt(j) >= '') {
        break;
      }
      j += 1;
    }
    for (;;)
    {
      j = i;
      if (k >= n) {
        break label98;
      }
      j = paramCharSequence.charAt(k);
      if (j >= 2048) {
        break;
      }
      i += (127 - j >>> 31);
      k += 1;
    }
    j = i + encodedLengthGeneral(paramCharSequence, k);
    label98:
    if (j < n) {
      throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (j + 4294967296L));
    }
    return j;
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new UnpairedSurrogateException(paramInt, m);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int estimateConsecutiveAscii(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt2 - 7) && ((paramByteBuffer.getLong(i) & 0x8080808080808080) == 0L)) {
      i += 8;
    }
    return i - paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  private static int incompleteStateFor(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return incompleteStateFor(paramInt1);
    case 1: 
      return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2));
    }
    return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2), paramByteBuffer.get(paramInt2 + 1));
  }
  
  private static int incompleteStateFor(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return incompleteStateFor(i);
    case 1: 
      return incompleteStateFor(i, paramArrayOfByte[paramInt1]);
    }
    return incompleteStateFor(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
  }
  
  static boolean isValidUtf8(ByteBuffer paramByteBuffer)
  {
    return processor.isValidUtf8(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return processor.isValidUtf8(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return processor.isValidUtf8(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
  {
    return processor.partialIsValidUtf8(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  public static int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return processor.partialIsValidUtf8(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  static abstract class Processor
  {
    private static int partialIsValidUtf8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      paramInt1 += Utf8.estimateConsecutiveAscii(paramByteBuffer, paramInt1, paramInt2);
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          paramInt1 = 0;
        }
        int j;
        int i;
        do
        {
          return paramInt1;
          j = paramInt1 + 1;
          i = paramByteBuffer.get(paramInt1);
          if (i >= 0) {
            break label263;
          }
          if (i >= -32) {
            break;
          }
          paramInt1 = i;
        } while (j >= paramInt2);
        if ((i < -62) || (paramByteBuffer.get(j) > -65)) {
          return -1;
        }
        paramInt1 = j + 1;
        label260:
        for (;;)
        {
          break;
          if (i < -16)
          {
            if (j >= paramInt2 - 1) {
              return Utf8.incompleteStateFor(paramByteBuffer, i, j, paramInt2 - j);
            }
            paramInt1 = j + 1;
            j = paramByteBuffer.get(j);
            if ((j > -65) || ((i == -32) && (j < -96)) || ((i == -19) && (j >= -96)) || (paramByteBuffer.get(paramInt1) > -65)) {
              return -1;
            }
            paramInt1 += 1;
          }
          else
          {
            if (j >= paramInt2 - 2) {
              return Utf8.incompleteStateFor(paramByteBuffer, i, j, paramInt2 - j);
            }
            int k = j + 1;
            j = paramByteBuffer.get(j);
            paramInt1 = k;
            if (j <= -65)
            {
              paramInt1 = k;
              if ((i << 28) + (j + 112) >> 30 == 0)
              {
                i = k + 1;
                if (paramByteBuffer.get(k) <= -65)
                {
                  paramInt1 = i + 1;
                  if (paramByteBuffer.get(i) <= -65) {
                    break label260;
                  }
                }
              }
            }
            return -1;
          }
        }
        label263:
        paramInt1 = j;
      }
    }
    
    abstract int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    final void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.hasArray())
      {
        int i = paramByteBuffer.arrayOffset();
        paramByteBuffer.position(Utf8.encode(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.position() + i, paramByteBuffer.remaining()) - i);
        return;
      }
      if (paramByteBuffer.isDirect())
      {
        encodeUtf8Direct(paramCharSequence, paramByteBuffer);
        return;
      }
      encodeUtf8Default(paramCharSequence, paramByteBuffer);
    }
    
    /* Error */
    final void encodeUtf8Default(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface 70 1 0
      //   6: istore 12
      //   8: aload_2
      //   9: invokevirtual 45	java/nio/ByteBuffer:position	()I
      //   12: istore 9
      //   14: iconst_0
      //   15: istore 6
      //   17: iload 6
      //   19: iload 12
      //   21: if_icmpge +59 -> 80
      //   24: iload 6
      //   26: istore 8
      //   28: iload 9
      //   30: istore 7
      //   32: aload_1
      //   33: iload 6
      //   35: invokeinterface 74 2 0
      //   40: istore 10
      //   42: iload 10
      //   44: sipush 128
      //   47: if_icmpge +33 -> 80
      //   50: iload 6
      //   52: istore 8
      //   54: iload 9
      //   56: istore 7
      //   58: aload_2
      //   59: iload 9
      //   61: iload 6
      //   63: iadd
      //   64: iload 10
      //   66: i2b
      //   67: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   70: pop
      //   71: iload 6
      //   73: iconst_1
      //   74: iadd
      //   75: istore 6
      //   77: goto -60 -> 17
      //   80: iload 6
      //   82: iload 12
      //   84: if_icmpne +22 -> 106
      //   87: iload 6
      //   89: istore 8
      //   91: iload 9
      //   93: istore 7
      //   95: aload_2
      //   96: iload 9
      //   98: iload 6
      //   100: iadd
      //   101: invokevirtual 54	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   104: pop
      //   105: return
      //   106: iload 9
      //   108: iload 6
      //   110: iadd
      //   111: istore 9
      //   113: iload 6
      //   115: iload 12
      //   117: if_icmpge +566 -> 683
      //   120: iload 6
      //   122: istore 7
      //   124: iload 9
      //   126: istore 8
      //   128: aload_1
      //   129: iload 6
      //   131: invokeinterface 74 2 0
      //   136: istore 4
      //   138: iload 4
      //   140: sipush 128
      //   143: if_icmpge +40 -> 183
      //   146: iload 6
      //   148: istore 7
      //   150: iload 9
      //   152: istore 8
      //   154: aload_2
      //   155: iload 9
      //   157: iload 4
      //   159: i2b
      //   160: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   163: pop
      //   164: iload 9
      //   166: istore 7
      //   168: iload 6
      //   170: iconst_1
      //   171: iadd
      //   172: istore 6
      //   174: iload 7
      //   176: iconst_1
      //   177: iadd
      //   178: istore 9
      //   180: goto -67 -> 113
      //   183: iload 4
      //   185: sipush 2048
      //   188: if_icmpge +147 -> 335
      //   191: iload 9
      //   193: iconst_1
      //   194: iadd
      //   195: istore 10
      //   197: iload 4
      //   199: bipush 6
      //   201: iushr
      //   202: sipush 192
      //   205: ior
      //   206: i2b
      //   207: istore_3
      //   208: iload 6
      //   210: istore 8
      //   212: iload 10
      //   214: istore 7
      //   216: aload_2
      //   217: iload 9
      //   219: iload_3
      //   220: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   223: pop
      //   224: iload 6
      //   226: istore 8
      //   228: iload 10
      //   230: istore 7
      //   232: aload_2
      //   233: iload 10
      //   235: iload 4
      //   237: bipush 63
      //   239: iand
      //   240: sipush 128
      //   243: ior
      //   244: i2b
      //   245: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   248: pop
      //   249: iload 10
      //   251: istore 7
      //   253: goto -85 -> 168
      //   256: astore 14
      //   258: iload 7
      //   260: istore 6
      //   262: iload 8
      //   264: istore 7
      //   266: aload_2
      //   267: invokevirtual 45	java/nio/ByteBuffer:position	()I
      //   270: istore 8
      //   272: iload 7
      //   274: iload 6
      //   276: aload_2
      //   277: invokevirtual 45	java/nio/ByteBuffer:position	()I
      //   280: isub
      //   281: iconst_1
      //   282: iadd
      //   283: invokestatic 84	java/lang/Math:max	(II)I
      //   286: istore 6
      //   288: new 86	java/lang/ArrayIndexOutOfBoundsException
      //   291: dup
      //   292: new 88	java/lang/StringBuilder
      //   295: dup
      //   296: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   299: ldc 91
      //   301: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: aload_1
      //   305: iload 7
      //   307: invokeinterface 74 2 0
      //   312: invokevirtual 98	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   315: ldc 100
      //   317: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   320: iload 8
      //   322: iload 6
      //   324: iadd
      //   325: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   328: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   331: invokespecial 110	java/lang/ArrayIndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
      //   334: athrow
      //   335: iload 4
      //   337: ldc 111
      //   339: if_icmplt +10 -> 349
      //   342: ldc 112
      //   344: iload 4
      //   346: if_icmpge +104 -> 450
      //   349: iload 9
      //   351: iconst_1
      //   352: iadd
      //   353: istore 10
      //   355: iload 4
      //   357: bipush 12
      //   359: iushr
      //   360: sipush 224
      //   363: ior
      //   364: i2b
      //   365: istore_3
      //   366: iload 6
      //   368: istore 8
      //   370: iload 10
      //   372: istore 7
      //   374: aload_2
      //   375: iload 9
      //   377: iload_3
      //   378: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   381: pop
      //   382: iload 10
      //   384: iconst_1
      //   385: iadd
      //   386: istore 9
      //   388: iload 4
      //   390: bipush 6
      //   392: iushr
      //   393: bipush 63
      //   395: iand
      //   396: sipush 128
      //   399: ior
      //   400: i2b
      //   401: istore_3
      //   402: iload 6
      //   404: istore 7
      //   406: iload 9
      //   408: istore 8
      //   410: aload_2
      //   411: iload 10
      //   413: iload_3
      //   414: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   417: pop
      //   418: iload 6
      //   420: istore 7
      //   422: iload 9
      //   424: istore 8
      //   426: aload_2
      //   427: iload 9
      //   429: iload 4
      //   431: bipush 63
      //   433: iand
      //   434: sipush 128
      //   437: ior
      //   438: i2b
      //   439: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   442: pop
      //   443: iload 9
      //   445: istore 7
      //   447: goto -279 -> 168
      //   450: iload 6
      //   452: istore 10
      //   454: iload 6
      //   456: iconst_1
      //   457: iadd
      //   458: iload 12
      //   460: if_icmpeq +49 -> 509
      //   463: iload 6
      //   465: iconst_1
      //   466: iadd
      //   467: istore 6
      //   469: iload 6
      //   471: istore 7
      //   473: iload 9
      //   475: istore 8
      //   477: aload_1
      //   478: iload 6
      //   480: invokeinterface 74 2 0
      //   485: istore 5
      //   487: iload 6
      //   489: istore 7
      //   491: iload 9
      //   493: istore 8
      //   495: iload 4
      //   497: iload 5
      //   499: invokestatic 118	java/lang/Character:isSurrogatePair	(CC)Z
      //   502: ifne +27 -> 529
      //   505: iload 6
      //   507: istore 10
      //   509: iload 10
      //   511: istore 7
      //   513: iload 9
      //   515: istore 8
      //   517: new 120	com/google/protobuf/Utf8$UnpairedSurrogateException
      //   520: dup
      //   521: iload 10
      //   523: iload 12
      //   525: invokespecial 123	com/google/protobuf/Utf8$UnpairedSurrogateException:<init>	(II)V
      //   528: athrow
      //   529: iload 6
      //   531: istore 7
      //   533: iload 9
      //   535: istore 8
      //   537: iload 4
      //   539: iload 5
      //   541: invokestatic 127	java/lang/Character:toCodePoint	(CC)I
      //   544: istore 13
      //   546: iload 9
      //   548: iconst_1
      //   549: iadd
      //   550: istore 10
      //   552: iload 13
      //   554: bipush 18
      //   556: iushr
      //   557: sipush 240
      //   560: ior
      //   561: i2b
      //   562: istore_3
      //   563: iload 6
      //   565: istore 8
      //   567: iload 10
      //   569: istore 7
      //   571: aload_2
      //   572: iload 9
      //   574: iload_3
      //   575: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   578: pop
      //   579: iload 10
      //   581: iconst_1
      //   582: iadd
      //   583: istore 11
      //   585: iload 13
      //   587: bipush 12
      //   589: iushr
      //   590: bipush 63
      //   592: iand
      //   593: sipush 128
      //   596: ior
      //   597: i2b
      //   598: istore_3
      //   599: iload 6
      //   601: istore 7
      //   603: iload 11
      //   605: istore 8
      //   607: aload_2
      //   608: iload 10
      //   610: iload_3
      //   611: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   614: pop
      //   615: iload 11
      //   617: iconst_1
      //   618: iadd
      //   619: istore 9
      //   621: iload 13
      //   623: bipush 6
      //   625: iushr
      //   626: bipush 63
      //   628: iand
      //   629: sipush 128
      //   632: ior
      //   633: i2b
      //   634: istore_3
      //   635: iload 6
      //   637: istore 8
      //   639: iload 9
      //   641: istore 7
      //   643: aload_2
      //   644: iload 11
      //   646: iload_3
      //   647: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   650: pop
      //   651: iload 6
      //   653: istore 8
      //   655: iload 9
      //   657: istore 7
      //   659: aload_2
      //   660: iload 9
      //   662: iload 13
      //   664: bipush 63
      //   666: iand
      //   667: sipush 128
      //   670: ior
      //   671: i2b
      //   672: invokevirtual 78	java/nio/ByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
      //   675: pop
      //   676: iload 9
      //   678: istore 7
      //   680: goto -512 -> 168
      //   683: iload 6
      //   685: istore 7
      //   687: iload 9
      //   689: istore 8
      //   691: aload_2
      //   692: iload 9
      //   694: invokevirtual 54	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   697: pop
      //   698: return
      //   699: astore 14
      //   701: iload 8
      //   703: istore 6
      //   705: goto -439 -> 266
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	708	0	this	Processor
      //   0	708	1	paramCharSequence	CharSequence
      //   0	708	2	paramByteBuffer	ByteBuffer
      //   207	440	3	b	byte
      //   136	402	4	i	int
      //   485	55	5	c	char
      //   15	689	6	j	int
      //   30	656	7	k	int
      //   26	676	8	m	int
      //   12	681	9	n	int
      //   40	569	10	i1	int
      //   583	62	11	i2	int
      //   6	518	12	i3	int
      //   544	123	13	i4	int
      //   256	1	14	localIndexOutOfBoundsException1	IndexOutOfBoundsException
      //   699	1	14	localIndexOutOfBoundsException2	IndexOutOfBoundsException
      // Exception table:
      //   from	to	target	type
      //   32	42	256	java/lang/IndexOutOfBoundsException
      //   58	71	256	java/lang/IndexOutOfBoundsException
      //   95	105	256	java/lang/IndexOutOfBoundsException
      //   216	224	256	java/lang/IndexOutOfBoundsException
      //   232	249	256	java/lang/IndexOutOfBoundsException
      //   374	382	256	java/lang/IndexOutOfBoundsException
      //   571	579	256	java/lang/IndexOutOfBoundsException
      //   643	651	256	java/lang/IndexOutOfBoundsException
      //   659	676	256	java/lang/IndexOutOfBoundsException
      //   128	138	699	java/lang/IndexOutOfBoundsException
      //   154	164	699	java/lang/IndexOutOfBoundsException
      //   410	418	699	java/lang/IndexOutOfBoundsException
      //   426	443	699	java/lang/IndexOutOfBoundsException
      //   477	487	699	java/lang/IndexOutOfBoundsException
      //   495	505	699	java/lang/IndexOutOfBoundsException
      //   517	529	699	java/lang/IndexOutOfBoundsException
      //   537	546	699	java/lang/IndexOutOfBoundsException
      //   607	615	699	java/lang/IndexOutOfBoundsException
      //   691	698	699	java/lang/IndexOutOfBoundsException
    }
    
    abstract void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer);
    
    final boolean isValidUtf8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
    {
      boolean bool = false;
      if (partialIsValidUtf8(0, paramByteBuffer, paramInt1, paramInt2) == 0) {
        bool = true;
      }
      return bool;
    }
    
    final boolean isValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      boolean bool = false;
      if (partialIsValidUtf8(0, paramArrayOfByte, paramInt1, paramInt2) == 0) {
        bool = true;
      }
      return bool;
    }
    
    final int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer.hasArray())
      {
        int i = paramByteBuffer.arrayOffset();
        return partialIsValidUtf8(paramInt1, paramByteBuffer.array(), i + paramInt2, i + paramInt3);
      }
      if (paramByteBuffer.isDirect()) {
        return partialIsValidUtf8Direct(paramInt1, paramByteBuffer, paramInt2, paramInt3);
      }
      return partialIsValidUtf8Default(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
    
    abstract int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
    
    final int partialIsValidUtf8Default(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      int n;
      int j;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        n = (byte)paramInt1;
        if (n < -32)
        {
          if ((n < -62) || (paramByteBuffer.get(paramInt2) > -65)) {
            return -1;
          }
        }
        else if (n < -16)
        {
          i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (i == 0)
          {
            i = paramInt2 + 1;
            j = paramByteBuffer.get(paramInt2);
            paramInt2 = j;
            paramInt1 = i;
            if (i >= paramInt3) {
              return Utf8.incompleteStateFor(n, j);
            }
          }
          else
          {
            paramInt1 = paramInt2;
            paramInt2 = i;
          }
          if ((paramInt2 > -65) || ((n == -32) && (paramInt2 < -96)) || ((n == -19) && (paramInt2 >= -96))) {
            break label325;
          }
          i = paramInt1 + 1;
          if (paramByteBuffer.get(paramInt1) <= -65) {
            break label313;
          }
        }
      }
      label313:
      label325:
      for (;;)
      {
        return -1;
        i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        j = 0;
        if (i == 0)
        {
          k = paramInt2 + 1;
          int m = paramByteBuffer.get(paramInt2);
          i = m;
          paramInt2 = j;
          paramInt1 = k;
          if (k >= paramInt3) {
            return Utf8.incompleteStateFor(n, m);
          }
        }
        else
        {
          j = (byte)(paramInt1 >> 16);
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
        int k = paramInt2;
        j = paramInt1;
        if (paramInt2 == 0)
        {
          j = paramInt1 + 1;
          k = paramByteBuffer.get(paramInt1);
          if (j >= paramInt3) {
            return Utf8.incompleteStateFor(n, i, k);
          }
        }
        if ((i <= -65) && ((n << 28) + (i + 112) >> 30 == 0) && (k <= -65))
        {
          i = j + 1;
          if (paramByteBuffer.get(j) <= -65) {}
        }
        for (;;)
        {
          return -1;
          i = paramInt2 + 1;
          return partialIsValidUtf8(paramByteBuffer, i, paramInt3);
        }
      }
    }
    
    abstract int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  }
  
  static final class SafeProcessor
    extends Utf8.Processor
  {
    private static int partialIsValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
        paramInt1 += 1;
      }
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      return partialIsValidUtf8NonAscii(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    private static int partialIsValidUtf8NonAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          paramInt1 = 0;
        }
        int i;
        int j;
        do
        {
          return paramInt1;
          i = paramInt1 + 1;
          j = paramArrayOfByte[paramInt1];
          if (j >= 0) {
            break label229;
          }
          if (j >= -32) {
            break;
          }
          paramInt1 = j;
        } while (i >= paramInt2);
        int k;
        if (j >= -62)
        {
          paramInt1 = i + 1;
          if (paramArrayOfByte[i] <= -65) {}
        }
        else
        {
          return -1;
          if (j < -16)
          {
            if (i >= paramInt2 - 1) {
              return Utf8.incompleteStateFor(paramArrayOfByte, i, paramInt2);
            }
            k = i + 1;
            paramInt1 = paramArrayOfByte[i];
            if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
              break label226;
            }
            paramInt1 = k + 1;
            if (paramArrayOfByte[k] <= -65) {
              break label223;
            }
          }
        }
        label223:
        label226:
        for (;;)
        {
          return -1;
          if (i >= paramInt2 - 2) {
            return Utf8.incompleteStateFor(paramArrayOfByte, i, paramInt2);
          }
          k = i + 1;
          i = paramArrayOfByte[i];
          paramInt1 = k;
          if (i <= -65)
          {
            paramInt1 = k;
            if ((j << 28) + (i + 112) >> 30 == 0)
            {
              j = k + 1;
              if (paramArrayOfByte[k] <= -65)
              {
                i = j + 1;
                paramInt1 = i;
                if (paramArrayOfByte[j] <= -65) {
                  break label223;
                }
                paramInt1 = i;
              }
            }
          }
          return -1;
          break;
        }
        label229:
        paramInt1 = i;
      }
    }
    
    int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int k = paramCharSequence.length();
      int j = 0;
      int m = paramInt1 + paramInt2;
      paramInt2 = j;
      while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
      {
        j = paramCharSequence.charAt(paramInt2);
        if (j >= 128) {
          break;
        }
        paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
        paramInt2 += 1;
      }
      if (paramInt2 == k) {
        return paramInt1 + k;
      }
      paramInt1 += paramInt2;
      if (paramInt2 < k)
      {
        int i = paramCharSequence.charAt(paramInt2);
        if ((i < 128) && (paramInt1 < m))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)i);
          paramInt1 = j;
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          if ((i < 2048) && (paramInt1 <= m - 2))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
            paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
            paramInt1 = j + 1;
          }
          else
          {
            int n;
            if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
            {
              j = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
              n = j + 1;
              paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
              paramInt1 = n + 1;
              paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
            }
            else
            {
              if (paramInt1 > m - 4) {
                break label446;
              }
              j = paramInt2;
              char c;
              if (paramInt2 + 1 != paramCharSequence.length())
              {
                paramInt2 += 1;
                c = paramCharSequence.charAt(paramInt2);
                if (!Character.isSurrogatePair(i, c)) {
                  j = paramInt2;
                }
              }
              else
              {
                throw new Utf8.UnpairedSurrogateException(j - 1, k);
              }
              j = Character.toCodePoint(i, c);
              n = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
              paramInt1 = n + 1;
              paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
              n = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
              paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
              paramInt1 = n + 1;
            }
          }
        }
        label446:
        if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
          throw new Utf8.UnpairedSurrogateException(paramInt2, k);
        }
        throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
      }
      return paramInt1;
    }
    
    void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      encodeUtf8Default(paramCharSequence, paramByteBuffer);
    }
    
    int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      int i = paramInt2;
      int n;
      int j;
      if (paramInt1 != 0)
      {
        if (paramInt2 >= paramInt3) {
          return paramInt1;
        }
        n = (byte)paramInt1;
        if (n < -32)
        {
          if ((n < -62) || (paramArrayOfByte[paramInt2] > -65)) {
            return -1;
          }
        }
        else if (n < -16)
        {
          i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (i == 0)
          {
            i = paramInt2 + 1;
            j = paramArrayOfByte[paramInt2];
            paramInt2 = j;
            paramInt1 = i;
            if (i >= paramInt3) {
              return Utf8.incompleteStateFor(n, j);
            }
          }
          else
          {
            paramInt1 = paramInt2;
            paramInt2 = i;
          }
          if ((paramInt2 > -65) || ((n == -32) && (paramInt2 < -96)) || ((n == -19) && (paramInt2 >= -96))) {
            break label313;
          }
          i = paramInt1 + 1;
          if (paramArrayOfByte[paramInt1] <= -65) {
            break label301;
          }
        }
      }
      label301:
      label313:
      for (;;)
      {
        return -1;
        i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        j = 0;
        if (i == 0)
        {
          k = paramInt2 + 1;
          int m = paramArrayOfByte[paramInt2];
          i = m;
          paramInt2 = j;
          paramInt1 = k;
          if (k >= paramInt3) {
            return Utf8.incompleteStateFor(n, m);
          }
        }
        else
        {
          j = (byte)(paramInt1 >> 16);
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
        int k = paramInt2;
        j = paramInt1;
        if (paramInt2 == 0)
        {
          j = paramInt1 + 1;
          k = paramArrayOfByte[paramInt1];
          if (j >= paramInt3) {
            return Utf8.incompleteStateFor(n, i, k);
          }
        }
        if ((i <= -65) && ((n << 28) + (i + 112) >> 30 == 0) && (k <= -65))
        {
          i = j + 1;
          if (paramArrayOfByte[j] <= -65) {}
        }
        for (;;)
        {
          return -1;
          i = paramInt2 + 1;
          return partialIsValidUtf8(paramArrayOfByte, i, paramInt3);
        }
      }
    }
    
    int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      return partialIsValidUtf8Default(paramInt1, paramByteBuffer, paramInt2, paramInt3);
    }
  }
  
  static class UnpairedSurrogateException
    extends IllegalArgumentException
  {
    UnpairedSurrogateException(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  static final class UnsafeProcessor
    extends Utf8.Processor
  {
    static boolean isAvailable()
    {
      return (UnsafeUtil.hasUnsafeArrayOperations()) && (UnsafeUtil.hasUnsafeByteBufferOperations());
    }
    
    private static int partialIsValidUtf8(long paramLong, int paramInt)
    {
      int i = unsafeEstimateConsecutiveAscii(paramLong, paramInt);
      paramLong += i;
      paramInt -= i;
      int j;
      long l;
      do
      {
        j = 0;
        i = paramInt;
        paramInt = j;
        for (;;)
        {
          l = paramLong;
          if (i <= 0) {
            break;
          }
          l = paramLong + 1L;
          paramInt = UnsafeUtil.getByte(paramLong);
          if (paramInt < 0) {
            break;
          }
          i -= 1;
          paramLong = l;
        }
        if (i == 0) {
          i = 0;
        }
        do
        {
          return i;
          j = i - 1;
          if (paramInt >= -32) {
            break;
          }
          i = paramInt;
        } while (j == 0);
        i = j - 1;
        if (paramInt < -62) {
          break label292;
        }
        paramLong = l + 1L;
        paramInt = i;
      } while (UnsafeUtil.getByte(l) <= -65);
      label289:
      label292:
      for (;;)
      {
        return -1;
        if (paramInt < -16)
        {
          if (j < 2) {
            return unsafeIncompleteStateFor(l, paramInt, j);
          }
          i = j - 2;
          paramLong = l + 1L;
          j = UnsafeUtil.getByte(l);
          if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96)) || (UnsafeUtil.getByte(paramLong) > -65)) {
            return -1;
          }
          paramLong += 1L;
          paramInt = i;
          break;
        }
        if (j < 3) {
          return unsafeIncompleteStateFor(l, paramInt, j);
        }
        i = j - 3;
        paramLong = l + 1L;
        j = UnsafeUtil.getByte(l);
        if ((j <= -65) && ((paramInt << 28) + (j + 112) >> 30 == 0))
        {
          l = paramLong + 1L;
          if (UnsafeUtil.getByte(paramLong) > -65) {
            break label289;
          }
          paramLong = l + 1L;
          paramInt = i;
          if (UnsafeUtil.getByte(l) <= -65) {
            break;
          }
        }
        for (;;)
        {
          return -1;
        }
      }
    }
    
    private static int partialIsValidUtf8(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      int i = unsafeEstimateConsecutiveAscii(paramArrayOfByte, paramLong, paramInt);
      paramInt -= i;
      paramLong += i;
      int j;
      long l;
      do
      {
        j = 0;
        i = paramInt;
        paramInt = j;
        for (;;)
        {
          l = paramLong;
          if (i <= 0) {
            break;
          }
          l = paramLong + 1L;
          paramInt = UnsafeUtil.getByte(paramArrayOfByte, paramLong);
          if (paramInt < 0) {
            break;
          }
          i -= 1;
          paramLong = l;
        }
        if (i == 0) {
          return 0;
        }
        i -= 1;
        if (paramInt >= -32) {
          break;
        }
        if (i == 0) {
          return paramInt;
        }
        i -= 1;
        if (paramInt < -62) {
          break label315;
        }
        paramLong = l + 1L;
        paramInt = i;
      } while (UnsafeUtil.getByte(paramArrayOfByte, l) <= -65);
      label312:
      label315:
      for (;;)
      {
        return -1;
        if (paramInt < -16)
        {
          if (i < 2) {
            return unsafeIncompleteStateFor(paramArrayOfByte, paramInt, l, i);
          }
          i -= 2;
          paramLong = l + 1L;
          j = UnsafeUtil.getByte(paramArrayOfByte, l);
          if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96)) || (UnsafeUtil.getByte(paramArrayOfByte, paramLong) > -65)) {
            return -1;
          }
          paramLong += 1L;
          paramInt = i;
          break;
        }
        if (i < 3) {
          return unsafeIncompleteStateFor(paramArrayOfByte, paramInt, l, i);
        }
        i -= 3;
        paramLong = l + 1L;
        j = UnsafeUtil.getByte(paramArrayOfByte, l);
        if ((j <= -65) && ((paramInt << 28) + (j + 112) >> 30 == 0))
        {
          l = paramLong + 1L;
          if (UnsafeUtil.getByte(paramArrayOfByte, paramLong) > -65) {
            break label312;
          }
          paramLong = l + 1L;
          paramInt = i;
          if (UnsafeUtil.getByte(paramArrayOfByte, l) <= -65) {
            break;
          }
        }
        for (;;)
        {
          return -1;
        }
      }
    }
    
    private static int unsafeEstimateConsecutiveAscii(long paramLong, int paramInt)
    {
      if (paramInt < 16) {
        return 0;
      }
      int j = (int)paramLong & 0x7;
      int i = j;
      while (i > 0)
      {
        if (UnsafeUtil.getByte(paramLong) < 0) {
          return j - i;
        }
        i -= 1;
        paramLong += 1L;
      }
      i = paramInt - j;
      while ((i >= 8) && ((UnsafeUtil.getLong(paramLong) & 0x8080808080808080) == 0L))
      {
        paramLong += 8L;
        i -= 8;
      }
      return paramInt - i;
    }
    
    private static int unsafeEstimateConsecutiveAscii(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      if (paramInt < 16) {
        return 0;
      }
      int j = (int)paramLong & 0x7;
      int i = j;
      while (i > 0)
      {
        if (UnsafeUtil.getByte(paramArrayOfByte, paramLong) < 0) {
          return j - i;
        }
        i -= 1;
        paramLong += 1L;
      }
      i = paramInt - j;
      while ((i >= 8) && ((UnsafeUtil.getLong(paramArrayOfByte, paramLong) & 0x8080808080808080) == 0L))
      {
        paramLong += 8L;
        i -= 8;
      }
      return paramInt - i;
    }
    
    private static int unsafeIncompleteStateFor(long paramLong, int paramInt1, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        return Utf8.incompleteStateFor(paramInt1);
      case 1: 
        return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramLong));
      }
      return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramLong), UnsafeUtil.getByte(1L + paramLong));
    }
    
    private static int unsafeIncompleteStateFor(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        return Utf8.incompleteStateFor(paramInt1);
      case 1: 
        return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramArrayOfByte, paramLong));
      }
      return Utf8.incompleteStateFor(paramInt1, UnsafeUtil.getByte(paramArrayOfByte, paramLong), UnsafeUtil.getByte(paramArrayOfByte, 1L + paramLong));
    }
    
    int encodeUtf8(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      long l1 = UnsafeUtil.getArrayBaseOffset() + paramInt1;
      long l3 = l1 + paramInt2;
      int j = paramCharSequence.length();
      if ((j > paramInt2) || (paramArrayOfByte.length - paramInt2 < paramInt1)) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + paramCharSequence.charAt(j - 1) + " at index " + (paramInt1 + paramInt2));
      }
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 >= 128) {
          break;
        }
        UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)paramInt1);
        paramInt2 += 1;
        l1 += 1L;
      }
      paramInt1 = paramInt2;
      long l2 = l1;
      if (paramInt2 == j) {
        return (int)(l1 - UnsafeUtil.getArrayBaseOffset());
      }
      if (paramInt1 < j)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < 128) && (l2 < l3))
        {
          l1 = l2 + 1L;
          UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)i);
        }
        for (;;)
        {
          paramInt1 += 1;
          l2 = l1;
          break;
          if ((i < 2048) && (l2 <= l3 - 2L))
          {
            l1 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(i >>> 6 | 0x3C0));
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
            l1 += 1L;
          }
          else if (((i < 55296) || (57343 < i)) && (l2 <= l3 - 3L))
          {
            l1 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(i >>> 12 | 0x1E0));
            l2 = l1 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(i >>> 6 & 0x3F | 0x80));
            l1 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (l2 > l3 - 4L) {
              break label550;
            }
            paramInt2 = paramInt1;
            char c;
            if (paramInt1 + 1 != j)
            {
              paramInt1 += 1;
              c = paramCharSequence.charAt(paramInt1);
              if (!Character.isSurrogatePair(i, c)) {
                paramInt2 = paramInt1;
              }
            }
            else
            {
              throw new Utf8.UnpairedSurrogateException(paramInt2 - 1, j);
            }
            paramInt2 = Character.toCodePoint(i, c);
            l1 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(paramInt2 >>> 18 | 0xF0));
            l2 = l1 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(paramInt2 >>> 12 & 0x3F | 0x80));
            l1 = l2 + 1L;
            UnsafeUtil.putByte(paramArrayOfByte, l2, (byte)(paramInt2 >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(paramArrayOfByte, l1, (byte)(paramInt2 & 0x3F | 0x80));
            l1 += 1L;
          }
        }
        label550:
        if ((55296 <= i) && (i <= 57343) && ((paramInt1 + 1 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt1 + 1))))) {
          throw new Utf8.UnpairedSurrogateException(paramInt1, j);
        }
        throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + l2);
      }
      return (int)(l2 - UnsafeUtil.getArrayBaseOffset());
    }
    
    void encodeUtf8Direct(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
    {
      long l3 = UnsafeUtil.addressOffset(paramByteBuffer);
      long l1 = l3 + paramByteBuffer.position();
      long l4 = l3 + paramByteBuffer.limit();
      int m = paramCharSequence.length();
      if (m > l4 - l1) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + paramCharSequence.charAt(m - 1) + " at index " + paramByteBuffer.limit());
      }
      int k = 0;
      while (k < m)
      {
        j = paramCharSequence.charAt(k);
        if (j >= 128) {
          break;
        }
        UnsafeUtil.putByte(l1, (byte)j);
        k += 1;
        l1 += 1L;
      }
      int j = k;
      long l2 = l1;
      if (k == m)
      {
        paramByteBuffer.position((int)(l1 - l3));
        return;
      }
      if (j < m)
      {
        int i = paramCharSequence.charAt(j);
        if ((i < 128) && (l2 < l4))
        {
          l1 = l2 + 1L;
          UnsafeUtil.putByte(l2, (byte)i);
        }
        for (;;)
        {
          j += 1;
          l2 = l1;
          break;
          if ((i < 2048) && (l2 <= l4 - 2L))
          {
            l1 = l2 + 1L;
            UnsafeUtil.putByte(l2, (byte)(i >>> 6 | 0x3C0));
            UnsafeUtil.putByte(l1, (byte)(i & 0x3F | 0x80));
            l1 += 1L;
          }
          else if (((i < 55296) || (57343 < i)) && (l2 <= l4 - 3L))
          {
            l1 = l2 + 1L;
            UnsafeUtil.putByte(l2, (byte)(i >>> 12 | 0x1E0));
            l2 = l1 + 1L;
            UnsafeUtil.putByte(l1, (byte)(i >>> 6 & 0x3F | 0x80));
            l1 = l2 + 1L;
            UnsafeUtil.putByte(l2, (byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (l2 > l4 - 4L) {
              break label550;
            }
            k = j;
            char c;
            if (j + 1 != m)
            {
              j += 1;
              c = paramCharSequence.charAt(j);
              if (!Character.isSurrogatePair(i, c)) {
                k = j;
              }
            }
            else
            {
              throw new Utf8.UnpairedSurrogateException(k - 1, m);
            }
            k = Character.toCodePoint(i, c);
            l1 = l2 + 1L;
            UnsafeUtil.putByte(l2, (byte)(k >>> 18 | 0xF0));
            l2 = l1 + 1L;
            UnsafeUtil.putByte(l1, (byte)(k >>> 12 & 0x3F | 0x80));
            l1 = l2 + 1L;
            UnsafeUtil.putByte(l2, (byte)(k >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(l1, (byte)(k & 0x3F | 0x80));
            l1 += 1L;
          }
        }
        label550:
        if ((55296 <= i) && (i <= 57343) && ((j + 1 == m) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(j + 1))))) {
          throw new Utf8.UnpairedSurrogateException(j, m);
        }
        throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + l2);
      }
      paramByteBuffer.position((int)(l2 - l3));
    }
    
    int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      long l2 = UnsafeUtil.getArrayBaseOffset() + paramInt2;
      long l4 = UnsafeUtil.getArrayBaseOffset() + paramInt3;
      long l1 = l2;
      int j;
      if (paramInt1 != 0)
      {
        if (l2 >= l4) {
          return paramInt1;
        }
        j = (byte)paramInt1;
        if (j < -32)
        {
          if ((j < -62) || (UnsafeUtil.getByte(paramArrayOfByte, l2) > -65)) {
            return -1;
          }
        }
        else if (j < -16)
        {
          paramInt1 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (paramInt1 == 0)
          {
            l1 = l2 + 1L;
            paramInt2 = UnsafeUtil.getByte(paramArrayOfByte, l2);
            paramInt1 = paramInt2;
            l2 = l1;
            if (l1 >= l4) {
              return Utf8.incompleteStateFor(j, paramInt2);
            }
          }
          if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
            break label400;
          }
          l1 = l2 + 1L;
          if (UnsafeUtil.getByte(paramArrayOfByte, l2) <= -65) {
            break label384;
          }
        }
      }
      label384:
      label400:
      for (;;)
      {
        return -1;
        paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt3 = 0;
        if (paramInt2 == 0)
        {
          long l3 = l2 + 1L;
          int i = UnsafeUtil.getByte(paramArrayOfByte, l2);
          paramInt2 = i;
          paramInt1 = paramInt3;
          l1 = l3;
          if (l3 >= l4) {
            return Utf8.incompleteStateFor(j, i);
          }
        }
        else
        {
          paramInt1 = (byte)(paramInt1 >> 16);
          l1 = l2;
        }
        paramInt3 = paramInt1;
        l2 = l1;
        if (paramInt1 == 0)
        {
          l2 = l1 + 1L;
          paramInt3 = UnsafeUtil.getByte(paramArrayOfByte, l1);
          if (l2 >= l4) {
            return Utf8.incompleteStateFor(j, paramInt2, paramInt3);
          }
        }
        if ((paramInt2 <= -65) && ((j << 28) + (paramInt2 + 112) >> 30 == 0) && (paramInt3 <= -65))
        {
          l1 = l2 + 1L;
          if (UnsafeUtil.getByte(paramArrayOfByte, l2) <= -65) {}
        }
        for (;;)
        {
          return -1;
          l1 = l2 + 1L;
          return partialIsValidUtf8(paramArrayOfByte, l1, (int)(l4 - l1));
        }
      }
    }
    
    int partialIsValidUtf8Direct(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3)
    {
      if ((paramInt2 | paramInt3 | paramByteBuffer.limit() - paramInt3) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramByteBuffer.limit()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      long l2 = UnsafeUtil.addressOffset(paramByteBuffer) + paramInt2;
      long l4 = l2 + (paramInt3 - paramInt2);
      long l1 = l2;
      int j;
      if (paramInt1 != 0)
      {
        if (l2 >= l4) {
          return paramInt1;
        }
        j = (byte)paramInt1;
        if (j < -32)
        {
          if ((j < -62) || (UnsafeUtil.getByte(l2) > -65)) {
            return -1;
          }
        }
        else if (j < -16)
        {
          paramInt1 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (paramInt1 == 0)
          {
            l1 = l2 + 1L;
            paramInt2 = UnsafeUtil.getByte(l2);
            l2 = l1;
            paramInt1 = paramInt2;
            if (l1 >= l4) {
              return Utf8.incompleteStateFor(j, paramInt2);
            }
          }
          if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
            break label399;
          }
          l1 = l2 + 1L;
          if (UnsafeUtil.getByte(l2) <= -65) {
            break label384;
          }
        }
      }
      label384:
      label399:
      for (;;)
      {
        return -1;
        paramInt2 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt3 = 0;
        if (paramInt2 == 0)
        {
          long l3 = l2 + 1L;
          int i = UnsafeUtil.getByte(l2);
          l1 = l3;
          paramInt2 = i;
          paramInt1 = paramInt3;
          if (l3 >= l4) {
            return Utf8.incompleteStateFor(j, i);
          }
        }
        else
        {
          paramInt1 = (byte)(paramInt1 >> 16);
          l1 = l2;
        }
        l2 = l1;
        paramInt3 = paramInt1;
        if (paramInt1 == 0)
        {
          l2 = l1 + 1L;
          paramInt3 = UnsafeUtil.getByte(l1);
          if (l2 >= l4) {
            return Utf8.incompleteStateFor(j, paramInt2, paramInt3);
          }
        }
        if ((paramInt2 <= -65) && ((j << 28) + (paramInt2 + 112) >> 30 == 0) && (paramInt3 <= -65))
        {
          l1 = l2 + 1L;
          if (UnsafeUtil.getByte(l2) <= -65) {}
        }
        for (;;)
        {
          return -1;
          l1 = l2 + 1L;
          return partialIsValidUtf8(l1, (int)(l4 - l1));
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/protobuf/Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */