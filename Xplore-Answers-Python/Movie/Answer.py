class Movie:
    def __init__(self,Movie_id,Movie_Name,Ticket_Cost,Cost_Category="Default"):
        self.Movie_1id=Movie_id
        self.Movie_Name=Movie_Name
        self.Ticket_Cost=Ticket_Cost
        self.Cost_Category=Cost_Category
        
    def Assign_Price_Category(self):
        CAT_ARR=["General","Silver","Gold","Platinum"]
        if self.Ticket_Cost in range(0,150):
            self.Cost_Category=CAT_ARR[0]
        elif self.Ticket_Cost in range(150,250):
            self.Cost_Category=CAT_ARR[1]
        elif self.Ticket_Cost in range(250,350):
            self.Cost_Category=CAT_ARR[2]
        elif(self.Ticket_Cost>=350):
            self.Cost_Category=CAT_ARR[3]
            
class Movie_Ticket:
    def __init__(self,Customer_Name,Movie_Name,Viewer_Count,Total_Ticket_Cost):
        self.Customer_Name=Customer_Name
        self.Movie_Name=Movie_Name
        self.Viewer_Count=Viewer_Count
        self.Total_Ticket_Cost=Total_Ticket_Cost
def getCategoryWiseCount(List_Movie_Objects): 
    for Object in List_Movie_Objects:
        Object.Assign_Price_Category()
    Dictionary={}
    for Object in List_Movie_Objects:
        Cost_Cat=Object.Cost_Category
        if Cost_Cat not in Dictionary.keys():
            Dictionary[Cost_Cat]=1
        else:
            Dictionary[Cost_Cat]=Dictionary[Cost_Cat]+1
    return Dictionary
def bookMovieTicket(List_Movie_Objects,Customer_Name,Movie_Name,Viewer_Count):
    for Object in List_Movie_Objects:
        val=Object.Movie_Name.lower()==Movie_Name.lower()
        if(val):
            Total_Ticket_Cost=Object.Ticket_Cost*Viewer_Count 
            return Total_Ticket_Cost
List_Movie_Objects=[] 
N=int(input())
for X in range(N):
    a=int(input())
    b=input()
    c=int(input())
    Object=Movie(a,b,c)
    List_Movie_Objects.append(Object)
Customer_Name=input() 
Movie_Name=input() 
Viewer_Count=int(input())
Dictionary=getCategoryWiseCount(List_Movie_Objects)
B=bookMovieTicket(List_Movie_Objects,Customer_Name,Movie_Name,Viewer_Count)
print('Category wise ticket count:')
for Object in Dictionary:
    print('{}:{}'.format(Object,Dictionary[Object]))
print(Customer_Name,B)
