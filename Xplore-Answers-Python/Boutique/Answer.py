finallist=[]
class Boutique:
    def __init__(self,boutiqueid,boutiquename,boutiquetype,boutiquerating,points):
        self.boutiqueid=boutiqueid
        self.boutiquename=boutiquename
        self.boutiquetype=boutiquetype
        self.boutiquerating=boutiquerating
        self.points=points
class OnlineBoutique:
    def __init__(self,p):
        self.p=p
    def getBoutique(self,lowrating,highrating,point,type):
        for i in self.p:
            if type.lower()==i.boutiquetype.lower():
                if lowrating<=i.boutiquerating and highrating>=i.boutiquerating:
                    r=0
                    r=point+i.points
                    finallist.append([i.boutiqueid,i.boutiquename,r])
        if len(finallist)>=1:
            finallist.sort(reverse=True)
            for i in range(len(l2)):
                print(finallist[i][0],l2[i][1],l2[i][2])
        else:
            print("No boutique found")

if __name__=="__main__":
    n=int(input())
    p=[]
    for i in range(n):
        boutiqueid=int(input())
        boutiquename=str(input())
        boutiquetype=str(input())
        boutiquerating=float(input())
        points=int(input())
        obj=Boutique(boutiqueid,boutiquename,boutiquetype,boutiquerating,points)
        p.append(obj)
    lowrating=float(input())
    highrating=float(input())
    point=int(input())
    type=str(input())
    obj1=OnlineBoutique(p)
    obj1.getBoutique(lowrating,highrating,point,type)
