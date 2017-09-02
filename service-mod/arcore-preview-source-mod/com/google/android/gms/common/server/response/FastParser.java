package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse>
{
  private static final char[] zzaTD = { 117, 108, 108 };
  private static final char[] zzaTE = { 114, 117, 101 };
  private static final char[] zzaTF = { 114, 117, 101, 34 };
  private static final char[] zzaTG = { 97, 108, 115, 101 };
  private static final char[] zzaTH = { 97, 108, 115, 101, 34 };
  private static final char[] zzaTI = { '\n' };
  private static final zza<Integer> zzaTK = new zza()
  {
    public Integer zzh(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return Integer.valueOf(FastParser.zza(paramAnonymousFastParser, paramAnonymousBufferedReader));
    }
  };
  private static final zza<Long> zzaTL = new zza()
  {
    public Long zzj(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return Long.valueOf(FastParser.zzb(paramAnonymousFastParser, paramAnonymousBufferedReader));
    }
  };
  private static final zza<Float> zzaTM = new zza()
  {
    public Float zzk(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return Float.valueOf(FastParser.zzc(paramAnonymousFastParser, paramAnonymousBufferedReader));
    }
  };
  private static final zza<Double> zzaTN = new zza()
  {
    public Double zzl(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return Double.valueOf(FastParser.zzd(paramAnonymousFastParser, paramAnonymousBufferedReader));
    }
  };
  private static final zza<Boolean> zzaTO = new zza()
  {
    public Boolean zzm(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return Boolean.valueOf(FastParser.zza(paramAnonymousFastParser, paramAnonymousBufferedReader, false));
    }
  };
  private static final zza<String> zzaTP = new zza()
  {
    public String zzn(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return FastParser.zze(paramAnonymousFastParser, paramAnonymousBufferedReader);
    }
  };
  private static final zza<BigInteger> zzaTQ = new zza()
  {
    public BigInteger zzo(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return FastParser.zzf(paramAnonymousFastParser, paramAnonymousBufferedReader);
    }
  };
  private static final zza<BigDecimal> zzaTR = new zza()
  {
    public BigDecimal zzp(FastParser paramAnonymousFastParser, BufferedReader paramAnonymousBufferedReader)
      throws FastParser.ParseException, IOException
    {
      return FastParser.zzg(paramAnonymousFastParser, paramAnonymousBufferedReader);
    }
  };
  private final char[] zzaTA = new char['Ѐ'];
  private final StringBuilder zzaTB = new StringBuilder(32);
  private final StringBuilder zzaTC = new StringBuilder(1024);
  private final Stack<Integer> zzaTJ = new Stack();
  private final char[] zzaTy = new char[1];
  private final char[] zzaTz = new char[32];
  
  private int zza(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    char c = zzk(paramBufferedReader);
    if (c == 0) {
      throw new ParseException("Unexpected EOF");
    }
    if (c == ',') {
      throw new ParseException("Missing value");
    }
    if (c == 'n')
    {
      zzb(paramBufferedReader, zzaTD);
      return 0;
    }
    paramBufferedReader.mark(1024);
    int i;
    int j;
    if (c == '"')
    {
      i = 0;
      j = 0;
      if ((j < paramArrayOfChar.length) && (paramBufferedReader.read(paramArrayOfChar, j, 1) != -1))
      {
        c = paramArrayOfChar[j];
        if (Character.isISOControl(c)) {
          throw new ParseException("Unexpected control character while reading string");
        }
        if ((c == '"') && (i == 0))
        {
          paramBufferedReader.reset();
          paramBufferedReader.skip(j + 1);
          return j;
        }
        if (c == '\\') {
          if (i == 0) {
            i = 1;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          i = 0;
          continue;
          i = 0;
        }
      }
      if (j == paramArrayOfChar.length) {
        throw new ParseException("Absurdly long value");
      }
    }
    else
    {
      paramArrayOfChar[0] = c;
      i = 1;
      for (;;)
      {
        j = i;
        if (i >= paramArrayOfChar.length) {
          break;
        }
        j = i;
        if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
          break;
        }
        if ((paramArrayOfChar[i] == '}') || (paramArrayOfChar[i] == ',') || (Character.isWhitespace(paramArrayOfChar[i])) || (paramArrayOfChar[i] == ']'))
        {
          paramBufferedReader.reset();
          paramBufferedReader.skip(i - 1);
          paramArrayOfChar[i] = '\000';
          return i;
        }
        i += 1;
      }
    }
    throw new ParseException("Unexpected EOF");
  }
  
  private static int zza(char[] paramArrayOfChar, int paramInt)
    throws FastParser.ParseException
  {
    int k = 0;
    int n;
    int j;
    if (paramInt > 0)
    {
      int m;
      if (paramArrayOfChar[0] == '-')
      {
        m = Integer.MIN_VALUE;
        n = 1;
      }
      for (int i = 1;; i = 0)
      {
        j = i;
        if (i >= paramInt) {
          break label74;
        }
        j = Character.digit(paramArrayOfChar[i], 10);
        if (j >= 0) {
          break;
        }
        throw new ParseException("Unexpected non-digit character");
        m = -2147483647;
        n = 0;
      }
      k = -j;
      j = i + 1;
      label74:
      while (j < paramInt)
      {
        i = Character.digit(paramArrayOfChar[j], 10);
        if (i < 0) {
          throw new ParseException("Unexpected non-digit character");
        }
        if (k < -214748364) {
          throw new ParseException("Number too large");
        }
        k *= 10;
        if (k < m + i) {
          throw new ParseException("Number too large");
        }
        k -= i;
        j += 1;
      }
    }
    throw new ParseException("No number to parse");
    if (n != 0)
    {
      if (j > 1) {
        return k;
      }
      throw new ParseException("No digits to parse");
    }
    return -k;
  }
  
  private String zza(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    String str = null;
    this.zzaTJ.push(Integer.valueOf(2));
    char c = zzk(paramBufferedReader);
    switch (c)
    {
    default: 
      throw new ParseException(19 + "Unexpected token: " + c);
    case '}': 
      zzgp(2);
    }
    do
    {
      return str;
      zzgp(2);
      zzgp(1);
      zzgp(5);
      return null;
      this.zzaTJ.push(Integer.valueOf(3));
      str = zzb(paramBufferedReader, this.zzaTz, this.zzaTB, null);
      zzgp(3);
    } while (zzk(paramBufferedReader) == ':');
    throw new ParseException("Expected key/value separator");
  }
  
  private String zza(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    switch (zzk(paramBufferedReader))
    {
    default: 
      throw new ParseException("Expected string");
    case '"': 
      return zzb(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
    }
    zzb(paramBufferedReader, zzaTD);
    return null;
  }
  
  private <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField)
    throws FastParser.ParseException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    char c = zzk(paramBufferedReader);
    switch (c)
    {
    default: 
      throw new ParseException(19 + "Unexpected token: " + c);
    case ']': 
      zzgp(5);
      return localArrayList;
    case '{': 
      this.zzaTJ.push(Integer.valueOf(1));
    }
    for (;;)
    {
      try
      {
        FastJsonResponse localFastJsonResponse = paramField.newConcreteTypeInstance();
        if (!zzc(paramBufferedReader, localFastJsonResponse)) {
          break;
        }
        localArrayList.add(localFastJsonResponse);
        c = zzk(paramBufferedReader);
        switch (c)
        {
        default: 
          throw new ParseException(19 + "Unexpected token: " + c);
        }
      }
      catch (InstantiationException paramBufferedReader)
      {
        throw new ParseException("Error instantiating inner object", paramBufferedReader);
      }
      catch (IllegalAccessException paramBufferedReader)
      {
        throw new ParseException("Error instantiating inner object", paramBufferedReader);
      }
      zzb(paramBufferedReader, zzaTD);
      zzgp(5);
      return null;
      if (zzk(paramBufferedReader) != '{') {
        throw new ParseException("Expected start of next object in array");
      }
      this.zzaTJ.push(Integer.valueOf(1));
    }
    zzgp(5);
    return localArrayList;
  }
  
  private <O> ArrayList<O> zza(BufferedReader paramBufferedReader, zza<O> paramzza)
    throws FastParser.ParseException, IOException
  {
    int i = zzk(paramBufferedReader);
    if (i == 110)
    {
      zzb(paramBufferedReader, zzaTD);
      return null;
    }
    if (i != 91) {
      throw new ParseException("Expected start of array");
    }
    this.zzaTJ.push(Integer.valueOf(5));
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramBufferedReader.mark(1024);
      switch (zzk(paramBufferedReader))
      {
      case ',': 
      default: 
        paramBufferedReader.reset();
        localArrayList.add(paramzza.zzi(this, paramBufferedReader));
      }
    }
    zzgp(5);
    return localArrayList;
    throw new ParseException("Unexpected EOF");
  }
  
  private void zza(BufferedReader paramBufferedReader, T paramT)
    throws FastParser.ParseException, IOException
  {
    char c = zzk(paramBufferedReader);
    switch (c)
    {
    default: 
      throw new ParseException(19 + "Unexpected token: " + c);
    case '{': 
      this.zzaTJ.push(Integer.valueOf(1));
      zzc(paramBufferedReader, paramT);
      return;
    case '[': 
      this.zzaTJ.push(Integer.valueOf(5));
      zzb(paramBufferedReader, paramT);
      return;
    }
    throw new ParseException("No data to parse");
  }
  
  private boolean zza(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws FastParser.ParseException, IOException
  {
    char c = zzk(paramBufferedReader);
    char[] arrayOfChar;
    switch (c)
    {
    default: 
      throw new ParseException(19 + "Unexpected token: " + c);
    case 'n': 
      zzb(paramBufferedReader, zzaTD);
      return false;
    case 't': 
      if (paramBoolean) {}
      for (arrayOfChar = zzaTF;; arrayOfChar = zzaTE)
      {
        zzb(paramBufferedReader, arrayOfChar);
        return true;
      }
    case 'f': 
      if (paramBoolean) {}
      for (arrayOfChar = zzaTH;; arrayOfChar = zzaTG)
      {
        zzb(paramBufferedReader, arrayOfChar);
        return false;
      }
    }
    if (paramBoolean) {
      throw new ParseException("No boolean value found in string");
    }
    return zza(paramBufferedReader, true);
  }
  
  private boolean zza(char[] paramArrayOfChar, char paramChar)
  {
    if (paramArrayOfChar == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfChar.length)
      {
        if (paramArrayOfChar[i] == paramChar) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static long zzb(char[] paramArrayOfChar, int paramInt)
    throws FastParser.ParseException
  {
    long l2;
    int j;
    int i;
    int k;
    long l1;
    if (paramInt > 0)
    {
      if (paramArrayOfChar[0] == '-')
      {
        l2 = Long.MIN_VALUE;
        j = 1;
        i = 1;
      }
      while (i < paramInt)
      {
        k = Character.digit(paramArrayOfChar[i], 10);
        if (k < 0)
        {
          throw new ParseException("Unexpected non-digit character");
          j = 0;
          l2 = -9223372036854775807L;
          i = 0;
        }
        else
        {
          l1 = -k;
          i += 1;
        }
      }
    }
    for (;;)
    {
      if (i < paramInt)
      {
        k = Character.digit(paramArrayOfChar[i], 10);
        if (k < 0) {
          throw new ParseException("Unexpected non-digit character");
        }
        if (l1 < -922337203685477580L) {
          throw new ParseException("Number too large");
        }
        l1 *= 10L;
        if (l1 < k + l2) {
          throw new ParseException("Number too large");
        }
        l1 -= k;
        i += 1;
        continue;
        throw new ParseException("No number to parse");
      }
      else
      {
        if (j != 0)
        {
          if (i > 1) {
            return l1;
          }
          throw new ParseException("No digits to parse");
        }
        return -l1;
        l1 = 0L;
      }
    }
  }
  
  private String zzb(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    paramBufferedReader.mark(1024);
    char c;
    int i;
    int j;
    switch (zzk(paramBufferedReader))
    {
    default: 
      paramBufferedReader.reset();
      zza(paramBufferedReader, this.zzaTA);
      c = zzk(paramBufferedReader);
      switch (c)
      {
      default: 
        throw new ParseException(18 + "Unexpected token " + c);
      }
    case '"': 
      if (paramBufferedReader.read(this.zzaTy) == -1) {
        throw new ParseException("Unexpected EOF while parsing string");
      }
      i = this.zzaTy[0];
      j = 0;
    }
    while ((i != 34) || (j != 0))
    {
      if (i == 92) {
        if (j == 0) {
          i = 1;
        }
      }
      while (paramBufferedReader.read(this.zzaTy) == -1)
      {
        throw new ParseException("Unexpected EOF while parsing string");
        i = 0;
        continue;
        i = 0;
      }
      c = this.zzaTy[0];
      if (Character.isISOControl(c))
      {
        throw new ParseException("Unexpected control character while reading string");
        this.zzaTJ.push(Integer.valueOf(1));
        paramBufferedReader.mark(32);
        c = zzk(paramBufferedReader);
        if (c == '}')
        {
          zzgp(1);
          break;
        }
        if (c == '"')
        {
          paramBufferedReader.reset();
          zza(paramBufferedReader);
          while (zzb(paramBufferedReader) != null) {}
          zzgp(1);
          break;
        }
        throw new ParseException(18 + "Unexpected token " + c);
        this.zzaTJ.push(Integer.valueOf(5));
        paramBufferedReader.mark(32);
        if (zzk(paramBufferedReader) == ']')
        {
          zzgp(5);
          break;
        }
        paramBufferedReader.reset();
        int k = 1;
        i = 0;
        j = 0;
        label396:
        if (k > 0)
        {
          c = zzk(paramBufferedReader);
          if (c == 0) {
            throw new ParseException("Unexpected EOF while parsing array");
          }
          if (Character.isISOControl(c)) {
            throw new ParseException("Unexpected control character while reading array");
          }
          if ((c != '"') || (j != 0)) {
            break label569;
          }
          if (i == 0) {
            i = 1;
          }
        }
        label457:
        label569:
        for (;;)
        {
          if ((c == '[') && (i == 0)) {
            k += 1;
          }
          for (;;)
          {
            if ((c == ']') && (i == 0)) {
              k -= 1;
            }
            for (;;)
            {
              if ((c == '\\') && (i != 0))
              {
                if (j == 0) {}
                for (j = 1;; j = 0)
                {
                  break;
                  i = 0;
                  break label457;
                }
              }
              j = 0;
              break label396;
              zzgp(5);
              break;
              throw new ParseException("Missing value");
              zzgp(2);
              return zza(paramBufferedReader);
              zzgp(2);
              return null;
            }
          }
        }
      }
      j = i;
      i = c;
    }
  }
  
  private String zzb(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int k = 0;
    int i = 0;
    for (;;)
    {
      int m = paramBufferedReader.read(paramArrayOfChar1);
      if (m == -1) {
        break;
      }
      int j = 0;
      if (j < m)
      {
        char c = paramArrayOfChar1[j];
        if ((Character.isISOControl(c)) && (!zza(paramArrayOfChar2, c))) {
          throw new ParseException("Unexpected control character while reading string");
        }
        if ((c == '"') && (i == 0))
        {
          paramStringBuilder.append(paramArrayOfChar1, 0, j);
          paramBufferedReader.reset();
          paramBufferedReader.skip(j + 1);
          if (k != 0) {
            return zzp.zzdg(paramStringBuilder.toString());
          }
          return paramStringBuilder.toString();
        }
        if (c == '\\') {
          if (i == 0)
          {
            i = 1;
            label143:
            k = 1;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          i = 0;
          break label143;
          i = 0;
        }
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, m);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private void zzb(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Object localObject = paramFastJsonResponse.getFieldMappings();
    if (((Map)localObject).size() != 1) {
      throw new ParseException("Object array response class must have a single Field");
    }
    localObject = (FastJsonResponse.Field)((Map.Entry)((Map)localObject).entrySet().iterator().next()).getValue();
    paramBufferedReader = zza(paramBufferedReader, (FastJsonResponse.Field)localObject);
    paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject, ((FastJsonResponse.Field)localObject).getOutputFieldName(), paramBufferedReader);
  }
  
  private void zzb(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int k = paramBufferedReader.read(this.zzaTz, 0, paramArrayOfChar.length - i);
      if (k == -1) {
        throw new ParseException("Unexpected EOF");
      }
      int j = 0;
      while (j < k)
      {
        if (paramArrayOfChar[(j + i)] != this.zzaTz[j]) {
          throw new ParseException("Unexpected character");
        }
        j += 1;
      }
      i += k;
    }
  }
  
  private String zzc(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    return zza(paramBufferedReader, this.zzaTz, this.zzaTB, null);
  }
  
  private boolean zzc(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Map localMap = paramFastJsonResponse.getFieldMappings();
    Object localObject2 = zza(paramBufferedReader);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      zzgp(1);
      return false;
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      localObject1 = (FastJsonResponse.Field)localMap.get(localObject1);
      if (localObject1 == null)
      {
        localObject1 = zzb(paramBufferedReader);
      }
      else
      {
        this.zzaTJ.push(Integer.valueOf(4));
        int i;
        switch (((FastJsonResponse.Field)localObject1).getTypeIn())
        {
        default: 
          i = ((FastJsonResponse.Field)localObject1).getTypeIn();
          throw new ParseException(30 + "Invalid field type " + i);
        case 0: 
          if (((FastJsonResponse.Field)localObject1).isTypeInArray()) {
            paramFastJsonResponse.setIntegers((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTK));
          }
          break;
        }
        for (;;)
        {
          zzgp(4);
          zzgp(2);
          char c = zzk(paramBufferedReader);
          switch (c)
          {
          case '}': 
          default: 
            throw new ParseException(55 + "Expected end of object or field separator, but found: " + c);
            paramFastJsonResponse.setInteger((FastJsonResponse.Field)localObject1, zze(paramBufferedReader));
            continue;
            if (((FastJsonResponse.Field)localObject1).isTypeInArray())
            {
              paramFastJsonResponse.setBigIntegers((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTQ));
            }
            else
            {
              paramFastJsonResponse.setBigInteger((FastJsonResponse.Field)localObject1, zzg(paramBufferedReader));
              continue;
              if (((FastJsonResponse.Field)localObject1).isTypeInArray())
              {
                paramFastJsonResponse.setLongs((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTL));
              }
              else
              {
                paramFastJsonResponse.setLong((FastJsonResponse.Field)localObject1, zzf(paramBufferedReader));
                continue;
                if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                {
                  paramFastJsonResponse.setFloats((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTM));
                }
                else
                {
                  paramFastJsonResponse.setFloat((FastJsonResponse.Field)localObject1, zzh(paramBufferedReader));
                  continue;
                  if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                  {
                    paramFastJsonResponse.setDoubles((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTN));
                  }
                  else
                  {
                    paramFastJsonResponse.setDouble((FastJsonResponse.Field)localObject1, zzi(paramBufferedReader));
                    continue;
                    if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                    {
                      paramFastJsonResponse.setBigDecimals((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTR));
                    }
                    else
                    {
                      paramFastJsonResponse.setBigDecimal((FastJsonResponse.Field)localObject1, zzj(paramBufferedReader));
                      continue;
                      if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                      {
                        paramFastJsonResponse.setBooleans((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTO));
                      }
                      else
                      {
                        paramFastJsonResponse.setBoolean((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, false));
                        continue;
                        if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                        {
                          paramFastJsonResponse.setStrings((FastJsonResponse.Field)localObject1, zza(paramBufferedReader, zzaTP));
                        }
                        else
                        {
                          paramFastJsonResponse.setString((FastJsonResponse.Field)localObject1, zzc(paramBufferedReader));
                          continue;
                          paramFastJsonResponse.setDecodedBytes((FastJsonResponse.Field)localObject1, zzc.decode(zza(paramBufferedReader, this.zzaTA, this.zzaTC, zzaTI)));
                          continue;
                          paramFastJsonResponse.setDecodedBytes((FastJsonResponse.Field)localObject1, zzc.zzdf(zza(paramBufferedReader, this.zzaTA, this.zzaTC, zzaTI)));
                          continue;
                          paramFastJsonResponse.setStringMap((FastJsonResponse.Field)localObject1, zzd(paramBufferedReader));
                          continue;
                          if (((FastJsonResponse.Field)localObject1).isTypeInArray())
                          {
                            i = zzk(paramBufferedReader);
                            if (i == 110)
                            {
                              zzb(paramBufferedReader, zzaTD);
                              paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject1, ((FastJsonResponse.Field)localObject1).getOutputFieldName(), null);
                            }
                            else
                            {
                              this.zzaTJ.push(Integer.valueOf(5));
                              if (i != 91) {
                                throw new ParseException("Expected array start");
                              }
                              paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject1, ((FastJsonResponse.Field)localObject1).getOutputFieldName(), zza(paramBufferedReader, (FastJsonResponse.Field)localObject1));
                            }
                          }
                          else
                          {
                            i = zzk(paramBufferedReader);
                            if (i == 110)
                            {
                              zzb(paramBufferedReader, zzaTD);
                              paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject1, ((FastJsonResponse.Field)localObject1).getOutputFieldName(), null);
                            }
                            else
                            {
                              this.zzaTJ.push(Integer.valueOf(1));
                              if (i != 123) {
                                throw new ParseException("Expected start of object");
                              }
                              try
                              {
                                localObject2 = ((FastJsonResponse.Field)localObject1).newConcreteTypeInstance();
                                zzc(paramBufferedReader, (FastJsonResponse)localObject2);
                                paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject1, ((FastJsonResponse.Field)localObject1).getOutputFieldName(), (FastJsonResponse)localObject2);
                              }
                              catch (InstantiationException paramBufferedReader)
                              {
                                throw new ParseException("Error instantiating inner object", paramBufferedReader);
                              }
                              catch (IllegalAccessException paramBufferedReader)
                              {
                                throw new ParseException("Error instantiating inner object", paramBufferedReader);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        localObject1 = zza(paramBufferedReader);
      }
    }
    zzgp(1);
    return true;
  }
  
  private HashMap<String, String> zzd(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zzk(paramBufferedReader);
    if (i == 110)
    {
      zzb(paramBufferedReader, zzaTD);
      return null;
    }
    if (i != 123) {
      throw new ParseException("Expected start of a map object");
    }
    this.zzaTJ.push(Integer.valueOf(1));
    HashMap localHashMap = new HashMap();
    char c;
    do
    {
      for (;;)
      {
        switch (zzk(paramBufferedReader))
        {
        }
      }
      throw new ParseException("Unexpected EOF");
      String str = zzb(paramBufferedReader, this.zzaTz, this.zzaTB, null);
      if (zzk(paramBufferedReader) != ':')
      {
        paramBufferedReader = String.valueOf(str);
        if (paramBufferedReader.length() != 0) {}
        for (paramBufferedReader = "No map value found for key ".concat(paramBufferedReader);; paramBufferedReader = new String("No map value found for key ")) {
          throw new ParseException(paramBufferedReader);
        }
      }
      if (zzk(paramBufferedReader) != '"')
      {
        paramBufferedReader = String.valueOf(str);
        if (paramBufferedReader.length() != 0) {}
        for (paramBufferedReader = "Expected String value for key ".concat(paramBufferedReader);; paramBufferedReader = new String("Expected String value for key ")) {
          throw new ParseException(paramBufferedReader);
        }
      }
      localHashMap.put(str, zzb(paramBufferedReader, this.zzaTz, this.zzaTB, null));
      c = zzk(paramBufferedReader);
    } while (c == ',');
    if (c == '}')
    {
      zzgp(1);
      return localHashMap;
    }
    throw new ParseException(48 + "Unexpected character while parsing string map: " + c);
    zzgp(1);
    return localHashMap;
  }
  
  private int zze(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return 0;
    }
    return zza(this.zzaTA, i);
  }
  
  private long zzf(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return 0L;
    }
    return zzb(this.zzaTA, i);
  }
  
  private BigInteger zzg(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return null;
    }
    return new BigInteger(new String(this.zzaTA, 0, i));
  }
  
  private void zzgp(int paramInt)
    throws FastParser.ParseException
  {
    if (this.zzaTJ.isEmpty()) {
      throw new ParseException(46 + "Expected state " + paramInt + " but had empty stack");
    }
    int i = ((Integer)this.zzaTJ.pop()).intValue();
    if (i != paramInt) {
      throw new ParseException(46 + "Expected state " + paramInt + " but had " + i);
    }
  }
  
  private float zzh(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return 0.0F;
    }
    return Float.parseFloat(new String(this.zzaTA, 0, i));
  }
  
  private double zzi(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return 0.0D;
    }
    return Double.parseDouble(new String(this.zzaTA, 0, i));
  }
  
  private BigDecimal zzj(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zza(paramBufferedReader, this.zzaTA);
    if (i == 0) {
      return null;
    }
    return new BigDecimal(new String(this.zzaTA, 0, i));
  }
  
  private char zzk(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    if (paramBufferedReader.read(this.zzaTy) == -1) {
      return '\000';
    }
    while (Character.isWhitespace(this.zzaTy[0])) {
      if (paramBufferedReader.read(this.zzaTy) == -1) {
        return '\000';
      }
    }
    return this.zzaTy[0];
  }
  
  public void parse(InputStream paramInputStream, T paramT)
    throws FastParser.ParseException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    try
    {
      this.zzaTJ.push(Integer.valueOf(0));
      zza(paramInputStream, paramT);
      zzgp(0);
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        Log.w("FastParser", "Failed to close reader while parsing.");
        return;
      }
      try
      {
        paramInputStream.close();
        throw paramT;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.w("FastParser", "Failed to close reader while parsing.");
        }
      }
    }
    catch (IOException paramT)
    {
      paramT = paramT;
      throw new ParseException(paramT);
    }
    finally {}
  }
  
  public void parse(String paramString, T paramT)
    throws FastParser.ParseException
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    try
    {
      parse(paramString, paramT);
      try
      {
        paramString.close();
        return;
      }
      catch (IOException paramString)
      {
        Log.w("FastParser", "Failed to close the input stream while parsing.");
        return;
      }
      try
      {
        paramString.close();
        throw paramT;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.w("FastParser", "Failed to close the input stream while parsing.");
        }
      }
    }
    finally {}
  }
  
  public static class ParseException
    extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }
    
    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  private static abstract interface zza<O>
  {
    public abstract O zzi(FastParser paramFastParser, BufferedReader paramBufferedReader)
      throws FastParser.ParseException, IOException;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/FastParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */