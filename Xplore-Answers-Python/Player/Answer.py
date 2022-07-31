class Player:
    def __init(self,name,countries,age,countryf):
        self.name=name
        self.countries=countries
        self.age=age
        self.countryf=countryf
        
def countplayers(p_list,icountry):
    k=0
    for p in p_list:
        if(p.countryf==icountry):
            k+=1
    print(k)
def pmaxcountry(p_list):
    maxi=0
    o_name=''
    for p in p_list:
        if(len(p.countries)>maxi):
            maxi=len(p.countries)
            o_name=p.name
    print(o_name)

n=int(input())
p_list=[]
for i in range(n):
    kp=[]
    name=input()
    k=int(input())
    for j in range(k):
        kp.append(input())
    age=int(input())
    country=input()
    p_list.append(Player(name,kp,age,country))
icountry=input()
countplayers(p_list,icountry)
pmaxcountry(p_list)
