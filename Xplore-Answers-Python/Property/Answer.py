f=[]
o={}
class Property:
    def __init__(self,propertytype,propvalue,maxbidp,):
        self.propertytype=propertytype
        self.propvalue=propvalue
        self.maxbidp=maxbidp
class Tender:
    def __init__(self,buyername,proptype,bidprice):
        self.buyername=buyername
        self.proptype=proptype
        self.bidprice=bidprice
def bidProperty(p,m):
    z=[]
    #r=""
    v=0
    for i in m:
        for j in p:
            if i.proptype.lower()==j.propertytype.lower():
                if i.bidprice>=j.propvalue and i.bidprice<=j.maxbidp:
                    if i.bidprice>=v:
                        v=i.bidprice
                        r=i.buyername
                        if j.propertytype in f:
                            pass
                        else:
                            f.append(j.propertytype)
                        if j.propertytype in o:
                            o[j.propertytype]=r
                        else:
                            o[j.propertytype]=r
    for i in f:
        for j in p:
            if i.lower()==j.propertytype.lower():
                p.remove(j)
    if len(o)>=1:
        for i in o:
            print(o[i])
    else:
        print("Property not found")
    for i in p:
        print(i.propertytype)
if __name__=="__main__":
    n=int(input())
    p=[]
    m=[]
    for i in range(n):
        pt=str(input())
        pv=int(input())
        maxbid=int(input())
        obj=Property(pt,pv,maxbid)
        p.append(obj)
    nn=int(input())
    for i in range(nn):
        bn=str(input())
        ppt=str(input())
        bidp=int(input())
        obj1=Tender(bn,ppt,bidp)
        m.append(obj1)
    bidProperty(p,m)
