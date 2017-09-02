package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzag
{
  public static final class zza
    extends zzcfz<zza>
  {
    public String zzaM = null;
    public String zzaO = null;
    public String zzaP = null;
    public String zzaQ = null;
    public String zzaZ = null;
    public Long zzbA = null;
    public Long zzbB = null;
    public zzag.zzb zzbC;
    public Long zzbD = null;
    public Long zzbE = null;
    public Long zzbF = null;
    public Long zzbG = null;
    public Long zzbH = null;
    public Long zzbI = null;
    public Integer zzbJ = null;
    public Integer zzbK = null;
    public Long zzbL = null;
    public Long zzbM = null;
    public Long zzbN = null;
    public Long zzbO = null;
    public Long zzbP = null;
    public Integer zzbQ = null;
    public zza zzbR;
    public zza[] zzbS = zza.zzu();
    public zzb zzbT;
    public Long zzbU = null;
    public String zzbV = null;
    public Integer zzbW = null;
    public Boolean zzbX = null;
    public String zzbY = null;
    public Long zzbZ = null;
    public String zzba = null;
    public Long zzbb = null;
    public Long zzbc = null;
    public Long zzbd = null;
    public Long zzbe = null;
    public Long zzbf = null;
    public Long zzbg = null;
    public Long zzbh = null;
    public Long zzbi = null;
    public Long zzbj = null;
    public Long zzbk = null;
    public String zzbl = null;
    public Long zzbm = null;
    public Long zzbn = null;
    public Long zzbo = null;
    public Long zzbp = null;
    public Long zzbq = null;
    public Long zzbr = null;
    public Long zzbs = null;
    public Long zzbt = null;
    public Long zzbu = null;
    public String zzbv = null;
    public Long zzbw = null;
    public Long zzbx = null;
    public Long zzby = null;
    public Long zzbz = null;
    public zzag.zze zzca;
    
    public zza()
    {
      this.Gi = -1;
    }
    
    public static zza zzd(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zza)zzcgg.zza(new zza(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzba != null) {
        i = j + zzcfy.zzv(1, this.zzba);
      }
      j = i;
      if (this.zzaZ != null) {
        j = i + zzcfy.zzv(2, this.zzaZ);
      }
      i = j;
      if (this.zzbb != null) {
        i = j + zzcfy.zzj(3, this.zzbb.longValue());
      }
      j = i;
      if (this.zzbc != null) {
        j = i + zzcfy.zzj(4, this.zzbc.longValue());
      }
      i = j;
      if (this.zzbd != null) {
        i = j + zzcfy.zzj(5, this.zzbd.longValue());
      }
      j = i;
      if (this.zzbe != null) {
        j = i + zzcfy.zzj(6, this.zzbe.longValue());
      }
      i = j;
      if (this.zzbf != null) {
        i = j + zzcfy.zzj(7, this.zzbf.longValue());
      }
      j = i;
      if (this.zzbg != null) {
        j = i + zzcfy.zzj(8, this.zzbg.longValue());
      }
      i = j;
      if (this.zzbh != null) {
        i = j + zzcfy.zzj(9, this.zzbh.longValue());
      }
      j = i;
      if (this.zzbi != null) {
        j = i + zzcfy.zzj(10, this.zzbi.longValue());
      }
      i = j;
      if (this.zzbj != null) {
        i = j + zzcfy.zzj(11, this.zzbj.longValue());
      }
      j = i;
      if (this.zzbk != null) {
        j = i + zzcfy.zzj(12, this.zzbk.longValue());
      }
      i = j;
      if (this.zzbl != null) {
        i = j + zzcfy.zzv(13, this.zzbl);
      }
      j = i;
      if (this.zzbm != null) {
        j = i + zzcfy.zzj(14, this.zzbm.longValue());
      }
      i = j;
      if (this.zzbn != null) {
        i = j + zzcfy.zzj(15, this.zzbn.longValue());
      }
      j = i;
      if (this.zzbo != null) {
        j = i + zzcfy.zzj(16, this.zzbo.longValue());
      }
      i = j;
      if (this.zzbp != null) {
        i = j + zzcfy.zzj(17, this.zzbp.longValue());
      }
      j = i;
      if (this.zzbq != null) {
        j = i + zzcfy.zzj(18, this.zzbq.longValue());
      }
      i = j;
      if (this.zzbr != null) {
        i = j + zzcfy.zzj(19, this.zzbr.longValue());
      }
      j = i;
      if (this.zzbs != null) {
        j = i + zzcfy.zzj(20, this.zzbs.longValue());
      }
      i = j;
      if (this.zzbU != null) {
        i = j + zzcfy.zzj(21, this.zzbU.longValue());
      }
      j = i;
      if (this.zzbt != null) {
        j = i + zzcfy.zzj(22, this.zzbt.longValue());
      }
      i = j;
      if (this.zzbu != null) {
        i = j + zzcfy.zzj(23, this.zzbu.longValue());
      }
      j = i;
      if (this.zzbV != null) {
        j = i + zzcfy.zzv(24, this.zzbV);
      }
      i = j;
      if (this.zzbZ != null) {
        i = j + zzcfy.zzj(25, this.zzbZ.longValue());
      }
      j = i;
      if (this.zzbW != null) {
        j = i + zzcfy.zzac(26, this.zzbW.intValue());
      }
      i = j;
      if (this.zzaM != null) {
        i = j + zzcfy.zzv(27, this.zzaM);
      }
      j = i;
      if (this.zzbX != null) {
        j = i + zzcfy.zzl(28, this.zzbX.booleanValue());
      }
      i = j;
      if (this.zzbv != null) {
        i = j + zzcfy.zzv(29, this.zzbv);
      }
      j = i;
      if (this.zzbY != null) {
        j = i + zzcfy.zzv(30, this.zzbY);
      }
      i = j;
      if (this.zzbw != null) {
        i = j + zzcfy.zzj(31, this.zzbw.longValue());
      }
      j = i;
      if (this.zzbx != null) {
        j = i + zzcfy.zzj(32, this.zzbx.longValue());
      }
      i = j;
      if (this.zzby != null) {
        i = j + zzcfy.zzj(33, this.zzby.longValue());
      }
      j = i;
      if (this.zzaO != null) {
        j = i + zzcfy.zzv(34, this.zzaO);
      }
      i = j;
      if (this.zzbz != null) {
        i = j + zzcfy.zzj(35, this.zzbz.longValue());
      }
      j = i;
      if (this.zzbA != null) {
        j = i + zzcfy.zzj(36, this.zzbA.longValue());
      }
      i = j;
      if (this.zzbB != null) {
        i = j + zzcfy.zzj(37, this.zzbB.longValue());
      }
      j = i;
      if (this.zzbC != null) {
        j = i + zzcfy.zzc(38, this.zzbC);
      }
      i = j;
      if (this.zzbD != null) {
        i = j + zzcfy.zzj(39, this.zzbD.longValue());
      }
      j = i;
      if (this.zzbE != null) {
        j = i + zzcfy.zzj(40, this.zzbE.longValue());
      }
      int k = j;
      if (this.zzbF != null) {
        k = j + zzcfy.zzj(41, this.zzbF.longValue());
      }
      i = k;
      if (this.zzbG != null) {
        i = k + zzcfy.zzj(42, this.zzbG.longValue());
      }
      j = i;
      if (this.zzbS != null)
      {
        j = i;
        if (this.zzbS.length > 0)
        {
          j = 0;
          while (j < this.zzbS.length)
          {
            zza localzza = this.zzbS[j];
            k = i;
            if (localzza != null) {
              k = i + zzcfy.zzc(43, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzbH != null) {
        i = j + zzcfy.zzj(44, this.zzbH.longValue());
      }
      j = i;
      if (this.zzbI != null) {
        j = i + zzcfy.zzj(45, this.zzbI.longValue());
      }
      i = j;
      if (this.zzaP != null) {
        i = j + zzcfy.zzv(46, this.zzaP);
      }
      j = i;
      if (this.zzaQ != null) {
        j = i + zzcfy.zzv(47, this.zzaQ);
      }
      i = j;
      if (this.zzbJ != null) {
        i = j + zzcfy.zzac(48, this.zzbJ.intValue());
      }
      j = i;
      if (this.zzbK != null) {
        j = i + zzcfy.zzac(49, this.zzbK.intValue());
      }
      i = j;
      if (this.zzbR != null) {
        i = j + zzcfy.zzc(50, this.zzbR);
      }
      j = i;
      if (this.zzbL != null) {
        j = i + zzcfy.zzj(51, this.zzbL.longValue());
      }
      i = j;
      if (this.zzbM != null) {
        i = j + zzcfy.zzj(52, this.zzbM.longValue());
      }
      j = i;
      if (this.zzbN != null) {
        j = i + zzcfy.zzj(53, this.zzbN.longValue());
      }
      i = j;
      if (this.zzbO != null) {
        i = j + zzcfy.zzj(54, this.zzbO.longValue());
      }
      j = i;
      if (this.zzbP != null) {
        j = i + zzcfy.zzj(55, this.zzbP.longValue());
      }
      i = j;
      if (this.zzbQ != null) {
        i = j + zzcfy.zzac(56, this.zzbQ.intValue());
      }
      j = i;
      if (this.zzbT != null) {
        j = i + zzcfy.zzc(57, this.zzbT);
      }
      i = j;
      if (this.zzca != null) {
        i = j + zzcfy.zzc(201, this.zzca);
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzba != null) {
        paramzzcfy.zzu(1, this.zzba);
      }
      if (this.zzaZ != null) {
        paramzzcfy.zzu(2, this.zzaZ);
      }
      if (this.zzbb != null) {
        paramzzcfy.zzf(3, this.zzbb.longValue());
      }
      if (this.zzbc != null) {
        paramzzcfy.zzf(4, this.zzbc.longValue());
      }
      if (this.zzbd != null) {
        paramzzcfy.zzf(5, this.zzbd.longValue());
      }
      if (this.zzbe != null) {
        paramzzcfy.zzf(6, this.zzbe.longValue());
      }
      if (this.zzbf != null) {
        paramzzcfy.zzf(7, this.zzbf.longValue());
      }
      if (this.zzbg != null) {
        paramzzcfy.zzf(8, this.zzbg.longValue());
      }
      if (this.zzbh != null) {
        paramzzcfy.zzf(9, this.zzbh.longValue());
      }
      if (this.zzbi != null) {
        paramzzcfy.zzf(10, this.zzbi.longValue());
      }
      if (this.zzbj != null) {
        paramzzcfy.zzf(11, this.zzbj.longValue());
      }
      if (this.zzbk != null) {
        paramzzcfy.zzf(12, this.zzbk.longValue());
      }
      if (this.zzbl != null) {
        paramzzcfy.zzu(13, this.zzbl);
      }
      if (this.zzbm != null) {
        paramzzcfy.zzf(14, this.zzbm.longValue());
      }
      if (this.zzbn != null) {
        paramzzcfy.zzf(15, this.zzbn.longValue());
      }
      if (this.zzbo != null) {
        paramzzcfy.zzf(16, this.zzbo.longValue());
      }
      if (this.zzbp != null) {
        paramzzcfy.zzf(17, this.zzbp.longValue());
      }
      if (this.zzbq != null) {
        paramzzcfy.zzf(18, this.zzbq.longValue());
      }
      if (this.zzbr != null) {
        paramzzcfy.zzf(19, this.zzbr.longValue());
      }
      if (this.zzbs != null) {
        paramzzcfy.zzf(20, this.zzbs.longValue());
      }
      if (this.zzbU != null) {
        paramzzcfy.zzf(21, this.zzbU.longValue());
      }
      if (this.zzbt != null) {
        paramzzcfy.zzf(22, this.zzbt.longValue());
      }
      if (this.zzbu != null) {
        paramzzcfy.zzf(23, this.zzbu.longValue());
      }
      if (this.zzbV != null) {
        paramzzcfy.zzu(24, this.zzbV);
      }
      if (this.zzbZ != null) {
        paramzzcfy.zzf(25, this.zzbZ.longValue());
      }
      if (this.zzbW != null) {
        paramzzcfy.zzaa(26, this.zzbW.intValue());
      }
      if (this.zzaM != null) {
        paramzzcfy.zzu(27, this.zzaM);
      }
      if (this.zzbX != null) {
        paramzzcfy.zzk(28, this.zzbX.booleanValue());
      }
      if (this.zzbv != null) {
        paramzzcfy.zzu(29, this.zzbv);
      }
      if (this.zzbY != null) {
        paramzzcfy.zzu(30, this.zzbY);
      }
      if (this.zzbw != null) {
        paramzzcfy.zzf(31, this.zzbw.longValue());
      }
      if (this.zzbx != null) {
        paramzzcfy.zzf(32, this.zzbx.longValue());
      }
      if (this.zzby != null) {
        paramzzcfy.zzf(33, this.zzby.longValue());
      }
      if (this.zzaO != null) {
        paramzzcfy.zzu(34, this.zzaO);
      }
      if (this.zzbz != null) {
        paramzzcfy.zzf(35, this.zzbz.longValue());
      }
      if (this.zzbA != null) {
        paramzzcfy.zzf(36, this.zzbA.longValue());
      }
      if (this.zzbB != null) {
        paramzzcfy.zzf(37, this.zzbB.longValue());
      }
      if (this.zzbC != null) {
        paramzzcfy.zza(38, this.zzbC);
      }
      if (this.zzbD != null) {
        paramzzcfy.zzf(39, this.zzbD.longValue());
      }
      if (this.zzbE != null) {
        paramzzcfy.zzf(40, this.zzbE.longValue());
      }
      if (this.zzbF != null) {
        paramzzcfy.zzf(41, this.zzbF.longValue());
      }
      if (this.zzbG != null) {
        paramzzcfy.zzf(42, this.zzbG.longValue());
      }
      if ((this.zzbS != null) && (this.zzbS.length > 0))
      {
        int i = 0;
        while (i < this.zzbS.length)
        {
          zza localzza = this.zzbS[i];
          if (localzza != null) {
            paramzzcfy.zza(43, localzza);
          }
          i += 1;
        }
      }
      if (this.zzbH != null) {
        paramzzcfy.zzf(44, this.zzbH.longValue());
      }
      if (this.zzbI != null) {
        paramzzcfy.zzf(45, this.zzbI.longValue());
      }
      if (this.zzaP != null) {
        paramzzcfy.zzu(46, this.zzaP);
      }
      if (this.zzaQ != null) {
        paramzzcfy.zzu(47, this.zzaQ);
      }
      if (this.zzbJ != null) {
        paramzzcfy.zzaa(48, this.zzbJ.intValue());
      }
      if (this.zzbK != null) {
        paramzzcfy.zzaa(49, this.zzbK.intValue());
      }
      if (this.zzbR != null) {
        paramzzcfy.zza(50, this.zzbR);
      }
      if (this.zzbL != null) {
        paramzzcfy.zzf(51, this.zzbL.longValue());
      }
      if (this.zzbM != null) {
        paramzzcfy.zzf(52, this.zzbM.longValue());
      }
      if (this.zzbN != null) {
        paramzzcfy.zzf(53, this.zzbN.longValue());
      }
      if (this.zzbO != null) {
        paramzzcfy.zzf(54, this.zzbO.longValue());
      }
      if (this.zzbP != null) {
        paramzzcfy.zzf(55, this.zzbP.longValue());
      }
      if (this.zzbQ != null) {
        paramzzcfy.zzaa(56, this.zzbQ.intValue());
      }
      if (this.zzbT != null) {
        paramzzcfy.zza(57, this.zzbT);
      }
      if (this.zzca != null) {
        paramzzcfy.zza(201, this.zzca);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zza zze(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.zzba = paramzzcfx.readString();
          break;
        case 18: 
          this.zzaZ = paramzzcfx.readString();
          break;
        case 24: 
          this.zzbb = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 32: 
          this.zzbc = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 40: 
          this.zzbd = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 48: 
          this.zzbe = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 56: 
          this.zzbf = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 64: 
          this.zzbg = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 72: 
          this.zzbh = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 80: 
          this.zzbi = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 88: 
          this.zzbj = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 96: 
          this.zzbk = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 106: 
          this.zzbl = paramzzcfx.readString();
          break;
        case 112: 
          this.zzbm = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 120: 
          this.zzbn = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 128: 
          this.zzbo = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 136: 
          this.zzbp = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 144: 
          this.zzbq = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 152: 
          this.zzbr = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 160: 
          this.zzbs = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 168: 
          this.zzbU = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 176: 
          this.zzbt = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 184: 
          this.zzbu = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 194: 
          this.zzbV = paramzzcfx.readString();
          break;
        case 200: 
          this.zzbZ = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 208: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
            this.zzbW = Integer.valueOf(i);
          }
          break;
        case 218: 
          this.zzaM = paramzzcfx.readString();
          break;
        case 224: 
          this.zzbX = Boolean.valueOf(paramzzcfx.zzamO());
          break;
        case 234: 
          this.zzbv = paramzzcfx.readString();
          break;
        case 242: 
          this.zzbY = paramzzcfx.readString();
          break;
        case 248: 
          this.zzbw = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 256: 
          this.zzbx = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 264: 
          this.zzby = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 274: 
          this.zzaO = paramzzcfx.readString();
          break;
        case 280: 
          this.zzbz = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 288: 
          this.zzbA = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 296: 
          this.zzbB = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 306: 
          if (this.zzbC == null) {
            this.zzbC = new zzag.zzb();
          }
          paramzzcfx.zza(this.zzbC);
          break;
        case 312: 
          this.zzbD = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 320: 
          this.zzbE = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 328: 
          this.zzbF = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 336: 
          this.zzbG = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 346: 
          int j = zzcgj.zzb(paramzzcfx, 346);
          if (this.zzbS == null) {}
          zza[] arrayOfzza;
          for (i = 0;; i = this.zzbS.length)
          {
            arrayOfzza = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbS, 0, arrayOfzza, 0, i);
              j = i;
            }
            while (j < arrayOfzza.length - 1)
            {
              arrayOfzza[j] = new zza();
              paramzzcfx.zza(arrayOfzza[j]);
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfzza[j] = new zza();
          paramzzcfx.zza(arrayOfzza[j]);
          this.zzbS = arrayOfzza;
          break;
        case 352: 
          this.zzbH = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 360: 
          this.zzbI = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 370: 
          this.zzaP = paramzzcfx.readString();
          break;
        case 378: 
          this.zzaQ = paramzzcfx.readString();
          break;
        case 384: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 1000: 
            this.zzbJ = Integer.valueOf(i);
          }
          break;
        case 392: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 1000: 
            this.zzbK = Integer.valueOf(i);
          }
          break;
        case 402: 
          if (this.zzbR == null) {
            this.zzbR = new zza();
          }
          paramzzcfx.zza(this.zzbR);
          break;
        case 408: 
          this.zzbL = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 416: 
          this.zzbM = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 424: 
          this.zzbN = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 432: 
          this.zzbO = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 440: 
          this.zzbP = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 448: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 1000: 
            this.zzbQ = Integer.valueOf(i);
          }
          break;
        case 458: 
          if (this.zzbT == null) {
            this.zzbT = new zzb();
          }
          paramzzcfx.zza(this.zzbT);
          break;
        case 1610: 
          if (this.zzca == null) {
            this.zzca = new zzag.zze();
          }
          paramzzcfx.zza(this.zzca);
        }
      }
    }
    
    public static final class zza
      extends zzcfz<zza>
    {
      private static volatile zza[] zzcb;
      public Long zzbm = null;
      public Long zzbn = null;
      public Long zzcc = null;
      public Long zzcd = null;
      public Long zzce = null;
      public Long zzcf = null;
      public Integer zzcg = null;
      public Long zzch = null;
      public Long zzci = null;
      public Long zzcj = null;
      public Integer zzck = null;
      public Long zzcl = null;
      
      public zza()
      {
        this.Gi = -1;
      }
      
      public static zza[] zzu()
      {
        if (zzcb == null) {}
        synchronized (zzcge.Gh)
        {
          if (zzcb == null) {
            zzcb = new zza[0];
          }
          return zzcb;
        }
      }
      
      protected int computeSerializedSize()
      {
        int j = super.computeSerializedSize();
        int i = j;
        if (this.zzbm != null) {
          i = j + zzcfy.zzj(1, this.zzbm.longValue());
        }
        j = i;
        if (this.zzbn != null) {
          j = i + zzcfy.zzj(2, this.zzbn.longValue());
        }
        i = j;
        if (this.zzcc != null) {
          i = j + zzcfy.zzj(3, this.zzcc.longValue());
        }
        j = i;
        if (this.zzcd != null) {
          j = i + zzcfy.zzj(4, this.zzcd.longValue());
        }
        i = j;
        if (this.zzce != null) {
          i = j + zzcfy.zzj(5, this.zzce.longValue());
        }
        j = i;
        if (this.zzcf != null) {
          j = i + zzcfy.zzj(6, this.zzcf.longValue());
        }
        i = j;
        if (this.zzcg != null) {
          i = j + zzcfy.zzac(7, this.zzcg.intValue());
        }
        j = i;
        if (this.zzch != null) {
          j = i + zzcfy.zzj(8, this.zzch.longValue());
        }
        i = j;
        if (this.zzci != null) {
          i = j + zzcfy.zzj(9, this.zzci.longValue());
        }
        j = i;
        if (this.zzcj != null) {
          j = i + zzcfy.zzj(10, this.zzcj.longValue());
        }
        i = j;
        if (this.zzck != null) {
          i = j + zzcfy.zzac(11, this.zzck.intValue());
        }
        j = i;
        if (this.zzcl != null) {
          j = i + zzcfy.zzj(12, this.zzcl.longValue());
        }
        return j;
      }
      
      public void writeTo(zzcfy paramzzcfy)
        throws IOException
      {
        if (this.zzbm != null) {
          paramzzcfy.zzf(1, this.zzbm.longValue());
        }
        if (this.zzbn != null) {
          paramzzcfy.zzf(2, this.zzbn.longValue());
        }
        if (this.zzcc != null) {
          paramzzcfy.zzf(3, this.zzcc.longValue());
        }
        if (this.zzcd != null) {
          paramzzcfy.zzf(4, this.zzcd.longValue());
        }
        if (this.zzce != null) {
          paramzzcfy.zzf(5, this.zzce.longValue());
        }
        if (this.zzcf != null) {
          paramzzcfy.zzf(6, this.zzcf.longValue());
        }
        if (this.zzcg != null) {
          paramzzcfy.zzaa(7, this.zzcg.intValue());
        }
        if (this.zzch != null) {
          paramzzcfy.zzf(8, this.zzch.longValue());
        }
        if (this.zzci != null) {
          paramzzcfy.zzf(9, this.zzci.longValue());
        }
        if (this.zzcj != null) {
          paramzzcfy.zzf(10, this.zzcj.longValue());
        }
        if (this.zzck != null) {
          paramzzcfy.zzaa(11, this.zzck.intValue());
        }
        if (this.zzcl != null) {
          paramzzcfy.zzf(12, this.zzcl.longValue());
        }
        super.writeTo(paramzzcfy);
      }
      
      public zza zzf(zzcfx paramzzcfx)
        throws IOException
      {
        for (;;)
        {
          int i = paramzzcfx.zzamI();
          switch (i)
          {
          default: 
            if (super.zza(paramzzcfx, i)) {}
            break;
          case 0: 
            return this;
          case 8: 
            this.zzbm = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 16: 
            this.zzbn = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 24: 
            this.zzcc = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 32: 
            this.zzcd = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 40: 
            this.zzce = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 48: 
            this.zzcf = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 56: 
            i = paramzzcfx.zzamM();
            switch (i)
            {
            default: 
              break;
            case 0: 
            case 1: 
            case 2: 
            case 1000: 
              this.zzcg = Integer.valueOf(i);
            }
            break;
          case 64: 
            this.zzch = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 72: 
            this.zzci = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 80: 
            this.zzcj = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 88: 
            i = paramzzcfx.zzamM();
            switch (i)
            {
            default: 
              break;
            case 0: 
            case 1: 
            case 2: 
            case 1000: 
              this.zzck = Integer.valueOf(i);
            }
            break;
          case 96: 
            this.zzcl = Long.valueOf(paramzzcfx.zzamL());
          }
        }
      }
    }
    
    public static final class zzb
      extends zzcfz<zzb>
    {
      public Long zzbO = null;
      public Long zzbP = null;
      public Long zzcm = null;
      
      public zzb()
      {
        this.Gi = -1;
      }
      
      protected int computeSerializedSize()
      {
        int j = super.computeSerializedSize();
        int i = j;
        if (this.zzbO != null) {
          i = j + zzcfy.zzj(1, this.zzbO.longValue());
        }
        j = i;
        if (this.zzbP != null) {
          j = i + zzcfy.zzj(2, this.zzbP.longValue());
        }
        i = j;
        if (this.zzcm != null) {
          i = j + zzcfy.zzj(3, this.zzcm.longValue());
        }
        return i;
      }
      
      public void writeTo(zzcfy paramzzcfy)
        throws IOException
      {
        if (this.zzbO != null) {
          paramzzcfy.zzf(1, this.zzbO.longValue());
        }
        if (this.zzbP != null) {
          paramzzcfy.zzf(2, this.zzbP.longValue());
        }
        if (this.zzcm != null) {
          paramzzcfy.zzf(3, this.zzcm.longValue());
        }
        super.writeTo(paramzzcfy);
      }
      
      public zzb zzg(zzcfx paramzzcfx)
        throws IOException
      {
        for (;;)
        {
          int i = paramzzcfx.zzamI();
          switch (i)
          {
          default: 
            if (super.zza(paramzzcfx, i)) {}
            break;
          case 0: 
            return this;
          case 8: 
            this.zzbO = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 16: 
            this.zzbP = Long.valueOf(paramzzcfx.zzamL());
            break;
          case 24: 
            this.zzcm = Long.valueOf(paramzzcfx.zzamL());
          }
        }
      }
    }
  }
  
  public static final class zzb
    extends zzcfz<zzb>
  {
    public Long zzcn = null;
    public Integer zzco = null;
    public Boolean zzcp = null;
    public int[] zzcq = zzcgj.Gn;
    public Long zzcr = null;
    
    public zzb()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int m = 0;
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzcn != null) {
        i = j + zzcfy.zzj(1, this.zzcn.longValue());
      }
      j = i;
      if (this.zzco != null) {
        j = i + zzcfy.zzac(2, this.zzco.intValue());
      }
      i = j;
      if (this.zzcp != null) {
        i = j + zzcfy.zzl(3, this.zzcp.booleanValue());
      }
      j = i;
      if (this.zzcq != null)
      {
        j = i;
        if (this.zzcq.length > 0)
        {
          int k = 0;
          j = m;
          while (j < this.zzcq.length)
          {
            k += zzcfy.zzBB(this.zzcq[j]);
            j += 1;
          }
          j = i + k + this.zzcq.length * 1;
        }
      }
      i = j;
      if (this.zzcr != null) {
        i = j + zzcfy.zzi(5, this.zzcr.longValue());
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzcn != null) {
        paramzzcfy.zzf(1, this.zzcn.longValue());
      }
      if (this.zzco != null) {
        paramzzcfy.zzaa(2, this.zzco.intValue());
      }
      if (this.zzcp != null) {
        paramzzcfy.zzk(3, this.zzcp.booleanValue());
      }
      if ((this.zzcq != null) && (this.zzcq.length > 0))
      {
        int i = 0;
        while (i < this.zzcq.length)
        {
          paramzzcfy.zzaa(4, this.zzcq[i]);
          i += 1;
        }
      }
      if (this.zzcr != null) {
        paramzzcfy.zze(5, this.zzcr.longValue());
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzb zzh(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzcn = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 16: 
          this.zzco = Integer.valueOf(paramzzcfx.zzamM());
          break;
        case 24: 
          this.zzcp = Boolean.valueOf(paramzzcfx.zzamO());
          break;
        case 32: 
          j = zzcgj.zzb(paramzzcfx, 32);
          if (this.zzcq == null) {}
          for (i = 0;; i = this.zzcq.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzcq, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzcfx.zzamM();
          this.zzcq = arrayOfInt;
          break;
        case 34: 
          int k = paramzzcfx.zzBv(paramzzcfx.zzamR());
          i = paramzzcfx.getPosition();
          j = 0;
          while (paramzzcfx.zzamW() > 0)
          {
            paramzzcfx.zzamM();
            j += 1;
          }
          paramzzcfx.zzBx(i);
          if (this.zzcq == null) {}
          for (i = 0;; i = this.zzcq.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzcq, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzcfx.zzamM();
              j += 1;
            }
          }
          this.zzcq = arrayOfInt;
          paramzzcfx.zzBw(k);
          break;
        case 40: 
          this.zzcr = Long.valueOf(paramzzcfx.zzamK());
        }
      }
    }
  }
  
  public static final class zzc
    extends zzcfz<zzc>
  {
    public byte[] zzcs = null;
    public byte[] zzct = null;
    
    public zzc()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzcs != null) {
        i = j + zzcfy.zzc(1, this.zzcs);
      }
      j = i;
      if (this.zzct != null) {
        j = i + zzcfy.zzc(2, this.zzct);
      }
      return j;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzcs != null) {
        paramzzcfy.zzb(1, this.zzcs);
      }
      if (this.zzct != null) {
        paramzzcfy.zzb(2, this.zzct);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzc zzi(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.zzcs = paramzzcfx.readBytes();
          break;
        case 18: 
          this.zzct = paramzzcfx.readBytes();
        }
      }
    }
  }
  
  public static final class zzd
    extends zzcfz<zzd>
  {
    public byte[] data = null;
    public byte[] zzcu = null;
    public byte[] zzcv = null;
    public byte[] zzcw = null;
    
    public zzd()
    {
      this.Gi = -1;
    }
    
    public static zzd zze(byte[] paramArrayOfByte)
      throws zzcgf
    {
      return (zzd)zzcgg.zza(new zzd(), paramArrayOfByte);
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.data != null) {
        i = j + zzcfy.zzc(1, this.data);
      }
      j = i;
      if (this.zzcu != null) {
        j = i + zzcfy.zzc(2, this.zzcu);
      }
      i = j;
      if (this.zzcv != null) {
        i = j + zzcfy.zzc(3, this.zzcv);
      }
      j = i;
      if (this.zzcw != null) {
        j = i + zzcfy.zzc(4, this.zzcw);
      }
      return j;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.data != null) {
        paramzzcfy.zzb(1, this.data);
      }
      if (this.zzcu != null) {
        paramzzcfy.zzb(2, this.zzcu);
      }
      if (this.zzcv != null) {
        paramzzcfy.zzb(3, this.zzcv);
      }
      if (this.zzcw != null) {
        paramzzcfy.zzb(4, this.zzcw);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzd zzj(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.data = paramzzcfx.readBytes();
          break;
        case 18: 
          this.zzcu = paramzzcfx.readBytes();
          break;
        case 26: 
          this.zzcv = paramzzcfx.readBytes();
          break;
        case 34: 
          this.zzcw = paramzzcfx.readBytes();
        }
      }
    }
  }
  
  public static final class zze
    extends zzcfz<zze>
  {
    public Long zzcn = null;
    public String zzcx = null;
    public byte[] zzcy = null;
    
    public zze()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int j = super.computeSerializedSize();
      int i = j;
      if (this.zzcn != null) {
        i = j + zzcfy.zzj(1, this.zzcn.longValue());
      }
      j = i;
      if (this.zzcx != null) {
        j = i + zzcfy.zzv(3, this.zzcx);
      }
      i = j;
      if (this.zzcy != null) {
        i = j + zzcfy.zzc(4, this.zzcy);
      }
      return i;
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if (this.zzcn != null) {
        paramzzcfy.zzf(1, this.zzcn.longValue());
      }
      if (this.zzcx != null) {
        paramzzcfy.zzu(3, this.zzcx);
      }
      if (this.zzcy != null) {
        paramzzcfy.zzb(4, this.zzcy);
      }
      super.writeTo(paramzzcfy);
    }
    
    public zze zzk(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzcn = Long.valueOf(paramzzcfx.zzamL());
          break;
        case 26: 
          this.zzcx = paramzzcfx.readString();
          break;
        case 34: 
          this.zzcy = paramzzcfx.readBytes();
        }
      }
    }
  }
  
  public static final class zzf
    extends zzcfz<zzf>
  {
    public Integer zzcA = null;
    public Integer zzcB = null;
    public byte[] zzcu = null;
    public byte[][] zzcz = zzcgj.Gt;
    
    public zzf()
    {
      this.Gi = -1;
    }
    
    protected int computeSerializedSize()
    {
      int i = 0;
      int i1 = super.computeSerializedSize();
      int k;
      if ((this.zzcz != null) && (this.zzcz.length > 0))
      {
        j = 0;
        int m;
        for (k = 0; i < this.zzcz.length; k = m)
        {
          byte[] arrayOfByte = this.zzcz[i];
          int n = j;
          m = k;
          if (arrayOfByte != null)
          {
            m = k + 1;
            n = j + zzcfy.zzau(arrayOfByte);
          }
          i += 1;
          j = n;
        }
      }
      for (int j = i1 + j + k * 1;; j = i1)
      {
        i = j;
        if (this.zzcu != null) {
          i = j + zzcfy.zzc(2, this.zzcu);
        }
        j = i;
        if (this.zzcA != null) {
          j = i + zzcfy.zzac(3, this.zzcA.intValue());
        }
        i = j;
        if (this.zzcB != null) {
          i = j + zzcfy.zzac(4, this.zzcB.intValue());
        }
        return i;
      }
    }
    
    public void writeTo(zzcfy paramzzcfy)
      throws IOException
    {
      if ((this.zzcz != null) && (this.zzcz.length > 0))
      {
        int i = 0;
        while (i < this.zzcz.length)
        {
          byte[] arrayOfByte = this.zzcz[i];
          if (arrayOfByte != null) {
            paramzzcfy.zzb(1, arrayOfByte);
          }
          i += 1;
        }
      }
      if (this.zzcu != null) {
        paramzzcfy.zzb(2, this.zzcu);
      }
      if (this.zzcA != null) {
        paramzzcfy.zzaa(3, this.zzcA.intValue());
      }
      if (this.zzcB != null) {
        paramzzcfy.zzaa(4, this.zzcB.intValue());
      }
      super.writeTo(paramzzcfy);
    }
    
    public zzf zzl(zzcfx paramzzcfx)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzcfx.zzamI();
        switch (i)
        {
        default: 
          if (super.zza(paramzzcfx, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          int j = zzcgj.zzb(paramzzcfx, 10);
          if (this.zzcz == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = this.zzcz.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzcz, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramzzcfx.readBytes();
              paramzzcfx.zzamI();
              j += 1;
            }
          }
          arrayOfByte[j] = paramzzcfx.readBytes();
          this.zzcz = arrayOfByte;
          break;
        case 18: 
          this.zzcu = paramzzcfx.readBytes();
          break;
        case 24: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
            this.zzcA = Integer.valueOf(i);
          }
          break;
        case 32: 
          i = paramzzcfx.zzamM();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
            this.zzcB = Integer.valueOf(i);
          }
          break;
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */