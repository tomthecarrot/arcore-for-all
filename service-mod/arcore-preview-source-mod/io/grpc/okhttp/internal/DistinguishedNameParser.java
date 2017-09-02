package io.grpc.okhttp.internal;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{
  private int beg;
  private char[] chars;
  private int cur;
  private final String dn;
  private int end;
  private final int length;
  private int pos;
  
  public DistinguishedNameParser(X500Principal paramX500Principal)
  {
    this.dn = paramX500Principal.getName("RFC2253");
    this.length = this.dn.length();
  }
  
  private String escapedAV()
  {
    this.beg = this.pos;
    this.end = this.pos;
    do
    {
      for (;;)
      {
        if (this.pos >= this.length) {
          return new String(this.chars, this.beg, this.end - this.beg);
        }
        switch (this.chars[this.pos])
        {
        default: 
          arrayOfChar = this.chars;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = this.chars[this.pos];
          this.pos += 1;
          break;
        case '+': 
        case ',': 
        case ';': 
          return new String(this.chars, this.beg, this.end - this.beg);
        case '\\': 
          arrayOfChar = this.chars;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = getEscaped();
          this.pos += 1;
        }
      }
      this.cur = this.end;
      this.pos += 1;
      char[] arrayOfChar = this.chars;
      int i = this.end;
      this.end = (i + 1);
      arrayOfChar[i] = ' ';
      while ((this.pos < this.length) && (this.chars[this.pos] == ' '))
      {
        arrayOfChar = this.chars;
        i = this.end;
        this.end = (i + 1);
        arrayOfChar[i] = ' ';
        this.pos += 1;
      }
    } while ((this.pos != this.length) && (this.chars[this.pos] != ',') && (this.chars[this.pos] != '+') && (this.chars[this.pos] != ';'));
    return new String(this.chars, this.beg, this.cur - this.beg);
  }
  
  private int getByte(int paramInt)
  {
    if (paramInt + 1 >= this.length) {
      throw new IllegalStateException("Malformed DN: " + this.dn);
    }
    int i = this.chars[paramInt];
    if ((i >= 48) && (i <= 57))
    {
      i -= 48;
      paramInt = this.chars[(paramInt + 1)];
      if ((paramInt < 48) || (paramInt > 57)) {
        break label166;
      }
      paramInt -= 48;
    }
    for (;;)
    {
      return (i << 4) + paramInt;
      if ((i >= 97) && (i <= 102))
      {
        i -= 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        i -= 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.dn);
      label166:
      if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label206;
        }
        paramInt -= 55;
      }
    }
    label206:
    throw new IllegalStateException("Malformed DN: " + this.dn);
  }
  
  private char getEscaped()
  {
    this.pos += 1;
    if (this.pos == this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }
    switch (this.chars[this.pos])
    {
    default: 
      return getUTF8();
    }
    return this.chars[this.pos];
  }
  
  private char getUTF8()
  {
    char c2 = '?';
    int i = getByte(this.pos);
    this.pos += 1;
    char c1;
    if (i < 128) {
      c1 = (char)i;
    }
    do
    {
      do
      {
        return c1;
        c1 = c2;
      } while (i < 192);
      c1 = c2;
    } while (i > 247);
    int j;
    if (i <= 223)
    {
      j = 1;
      i &= 0x1F;
    }
    int k;
    for (;;)
    {
      int m = 0;
      k = i;
      i = m;
      for (;;)
      {
        if (i >= j) {
          break label214;
        }
        this.pos += 1;
        c1 = c2;
        if (this.pos == this.length) {
          break;
        }
        c1 = c2;
        if (this.chars[this.pos] != '\\') {
          break;
        }
        this.pos += 1;
        m = getByte(this.pos);
        this.pos += 1;
        c1 = c2;
        if ((m & 0xC0) != 128) {
          break;
        }
        k = (k << 6) + (m & 0x3F);
        i += 1;
      }
      if (i <= 239)
      {
        j = 2;
        i &= 0xF;
      }
      else
      {
        j = 3;
        i &= 0x7;
      }
    }
    label214:
    return (char)k;
  }
  
  private String hexAV()
  {
    if (this.pos + 4 >= this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }
    this.beg = this.pos;
    int k;
    for (this.pos += 1;; this.pos += 1)
    {
      if ((this.pos == this.length) || (this.chars[this.pos] == '+') || (this.chars[this.pos] == ',') || (this.chars[this.pos] == ';')) {
        this.end = this.pos;
      }
      for (;;)
      {
        k = this.end - this.beg;
        if ((k >= 5) && ((k & 0x1) != 0)) {
          break label307;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        if (this.chars[this.pos] != ' ') {
          break;
        }
        this.end = this.pos;
        for (this.pos += 1; (this.pos < this.length) && (this.chars[this.pos] == ' '); this.pos += 1) {}
      }
      if ((this.chars[this.pos] >= 'A') && (this.chars[this.pos] <= 'F'))
      {
        localObject = this.chars;
        i = this.pos;
        localObject[i] = ((char)(localObject[i] + ' '));
      }
    }
    label307:
    Object localObject = new byte[k / 2];
    int i = 0;
    int j = this.beg + 1;
    while (i < localObject.length)
    {
      localObject[i] = ((byte)getByte(j));
      j += 2;
      i += 1;
    }
    return new String(this.chars, this.beg, k);
  }
  
  private String nextAT()
  {
    while ((this.pos < this.length) && (this.chars[this.pos] == ' ')) {
      this.pos += 1;
    }
    if (this.pos == this.length) {
      return null;
    }
    this.beg = this.pos;
    for (this.pos += 1; (this.pos < this.length) && (this.chars[this.pos] != '=') && (this.chars[this.pos] != ' '); this.pos += 1) {}
    if (this.pos >= this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }
    this.end = this.pos;
    if (this.chars[this.pos] == ' ')
    {
      while ((this.pos < this.length) && (this.chars[this.pos] != '=') && (this.chars[this.pos] == ' ')) {
        this.pos += 1;
      }
      if ((this.chars[this.pos] != '=') || (this.pos == this.length)) {
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
      }
    }
    for (this.pos += 1; (this.pos < this.length) && (this.chars[this.pos] == ' '); this.pos += 1) {}
    if ((this.end - this.beg > 4) && (this.chars[(this.beg + 3)] == '.') && ((this.chars[this.beg] == 'O') || (this.chars[this.beg] == 'o')) && ((this.chars[(this.beg + 1)] == 'I') || (this.chars[(this.beg + 1)] == 'i')) && ((this.chars[(this.beg + 2)] == 'D') || (this.chars[(this.beg + 2)] == 'd'))) {
      this.beg += 4;
    }
    return new String(this.chars, this.beg, this.end - this.beg);
  }
  
  private String quotedAV()
  {
    this.pos += 1;
    this.beg = this.pos;
    this.end = this.beg;
    if (this.pos == this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }
    if (this.chars[this.pos] == '"') {
      for (this.pos += 1; (this.pos < this.length) && (this.chars[this.pos] == ' '); this.pos += 1) {}
    }
    if (this.chars[this.pos] == '\\') {
      this.chars[this.end] = getEscaped();
    }
    for (;;)
    {
      this.pos += 1;
      this.end += 1;
      break;
      this.chars[this.end] = this.chars[this.pos];
    }
    return new String(this.chars, this.beg, this.end - this.beg);
  }
  
  public String findMostSpecific(String paramString)
  {
    this.pos = 0;
    this.beg = 0;
    this.end = 0;
    this.cur = 0;
    this.chars = this.dn.toCharArray();
    String str1 = nextAT();
    String str2 = str1;
    if (str1 == null)
    {
      str1 = null;
      return str1;
    }
    str1 = "";
    if (this.pos == this.length) {
      return null;
    }
    switch (this.chars[this.pos])
    {
    default: 
      str1 = escapedAV();
    }
    while (!paramString.equalsIgnoreCase(str2))
    {
      if (this.pos < this.length) {
        break label162;
      }
      return null;
      str1 = quotedAV();
      continue;
      str1 = hexAV();
    }
    label162:
    if ((this.chars[this.pos] == ',') || (this.chars[this.pos] == ';')) {}
    while (this.chars[this.pos] == '+')
    {
      this.pos += 1;
      str1 = nextAT();
      str2 = str1;
      if (str1 != null) {
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.dn);
    }
    throw new IllegalStateException("Malformed DN: " + this.dn);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/okhttp/internal/DistinguishedNameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */