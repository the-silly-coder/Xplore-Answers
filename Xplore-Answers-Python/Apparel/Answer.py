class Apparel:
    def __init__(self,apparelbrand,type,price,instock):
        self.apparelbrand=apparelbrand
        self.type=type
        self.price=price
        self.instock=instock
class Store:
    def __init__(self,ApparelList):
        self.ApparelList=ApparelList
    def display_available(self,brand,type1):
        for i in self.ApparelList:
            if(i.apparelbrand.lower()==brand.lower() and i.type.lower()==type1.lower()):
                for key,value in i.instock.items():
                    print(key,":",value)
    def checkApparelAvailability(self,brand,type1,size,number):
        for i in self.ApparelList:
            if(i.apparelbrand.lower()==brand.lower() and i.type.lower()==type1.lower()):
                for key,value in i.instock.items():
                    if key.lower()==size.lower():
                        if value>=number:
                            i.instock[key]=value-number
                            return "True"
                        else:
                            return "False"
        return "not found"
if __name__=="__main__":
    noe=int(input())
    ApparelList=[]
    for i in range(noe):
        apparelbrand=input()
        type=input()
        price=int(input())
        instock={}
        num=int(input())
        for i in range(num):
            key=input()
            value=int(input())
            instock[key]=value
        ApparelList.append(Apparel(apparelbrand,type,price,instock))
    obj=Store(ApparelList)
    brand=input()
    type1=input()
    size=input().upper()
    number=int(input())
    res=obj.checkApparelAvailability(brand,type1,size,number)
    if res=="True":
        print("Size is Available")
        obj.display_available(brand,type1)
    elif res=="False":
        print("Size is not Available")
        obj.display_available(brand,type1)
    elif(res=="not found"):
        print("Size not Available")
        print("Apparel not found")
