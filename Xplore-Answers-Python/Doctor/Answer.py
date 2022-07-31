class Doctor:
    def __init__(self,id,n,dn,f,s):
        self.doctorId=id
        self.doctorName=n
        self.deptName=dn
        self.consultFee=f
        self.sundayAvailable=s
class Hospital:
    def __init__(self,dl):
        self.doctorlist=dl

    def  getDoctorList(self,dn):
        l=[]
        for i in self.doctorlist:
            if i.deptName==dn and i.sundayAvailable=="available":
                l.append(i)
        if (len(l)>0):
          return l
        else:
          return None

    def selectDoctor(self,f):
      t=0
      for i in self.doctorlist:
        if i.sundayAvailable=="not available" and i.consultFee>f :
          self.doctorlist.remove(i)
          t=1
      if t==1:
        return True
      else:
        return False

if __name__ == _'_main__':
  count=5
  dl=[]
  for i in range(count):
    id=int(input())
    n=input()
    dn=input()
    f=int(input())
    s=input()
    dl.append(Doctor(id,n,dn,f,s))
  h=Hospital(dl)
  dn=input()
  f=int(input())
  res1=h.getDoctorList(dn)
  res2=h.selectDoctor(f)

  if res1==None:
    print("Doctor Not Found")
  else:
    for i in res1:
      print(i.doctorId," ",i.doctorName)

  if res2==True:
    dl.sort(key=lambda x: x.consultFee)
    for i in h.doctorlist:
      print(i.doctorId," ",i.doctorName," ",i.consultFee)
  else:
    print("Returning the original list:")
    for i in h.doctorlist:
      print(i.doctorId," ",i.doctorName)
