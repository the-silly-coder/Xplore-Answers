class Employee:
    def _init_(self,n,d,s,l):
        self.name=n
        self.designation=d
        self.salary=s
        self.leavesbalance=l
 
class Organization:
    def _init_(self,emps):
        self.employee_list=emps
 
    def display_leaves(self,name):
        for i in self.employee_list:
            if i.name==name:
                for a,b in i.leavesbalance.items():
                    print(a,":",b)
         
    def checkLeaveEligibility(self,empname,tl,nol):
        for i in self.employee_list:
            if i.name==empname:
                for a,b in i.leavesbalance.items():
                    if a==tl:
                        if b>=nol:
                          i.leavesbalance[a]=b-nol
                          return 'True'
                        else:
                            return 'False'
        return 'not found'
if _name_ == '_main_':
    l=[]
    n=int(input())
    for i in range(n):
        leaves={}
        name=input()
        desig=input()
        salary=int(input())
        ltype=int(input())
        for i in range(ltype):
          key=input()
          value=int(input())
          leaves[key]=value
        l.append(Employee(name,desig,salary,leaves))
    o=Organization(l)
    empname=input()
    Itype=input()
    nol=int(input())
    if(o.checkLeaveEligibility(empname,Itype,nol)=='True'):
      print("leave granted")
      o.display_leaves(empname)
    elif(o.checkLeaveEligibility(empname,Itype,nol)=='False'):
      print("leave not granted")
      o.display_leaves(empname)
    elif(o.checkLeaveEligibility(empname,Itype,nol)=='not found'):
      print("leave not granted")
      print("Employee not found")
