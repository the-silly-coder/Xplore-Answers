class Product:
    def __init__(self,productName,productType,unitPrice,qtyOnHand):
        self.productName=productName
        self.productType=productType
        self.unitPrice=unitPrice
        self.qtyOnHand=qtyOnHand
class Store:
    def __init__(self,productList):
        self.productList=productList
    def purchaseProduct(self,Name,quantity):
        for p in self.productList:
            if p.productName==Name and p.qtyOnHand>=quantity:
                p.qtyOnHand=p.qtyOnHand-quantity
                bill=(p.unitPrice*quantity)
                return bill
        return 0
if __name__=="__main__":
    n=int(input())
    ProductList=[]
    for i in range(n):
        name=input()
        type=input()
        price=int(input())
        qty=int(input())
        p=Product(name,type,price,qty)
        ProductList.append(p)
    productRequired=input()
    productQuantity=int(input())
    obj=Store(ProductList)
    x=obj.purchaseProduct(productRequired,productQuantity)
    if x==0:
        print("Product not available")
        for i in obj.productList:
            print(i.productName,i.qtyOnHand)
    else:
        print("Product available")
        for i in obj.productList:
            print(i.productName,i.qtyOnHand)
