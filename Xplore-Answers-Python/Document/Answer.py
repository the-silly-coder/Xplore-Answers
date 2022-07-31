class Document:
    def __init__(self, docid, name, details):
        self.docid = docid
        self.docName = name
        self.docDetails = details
class DocumentArchive:
    def __init__(self, id, List ):
        self.archiveId = id
        self.documentList = List
    def findDateFromDocumentDetails(self):
        doclist = []
        for doc in self.documentList:
            val = doc.docDetails.split(',')
            #print(val, doc.docDetails.count('/'))
            if doc.docDetails.count('/')==2:
                for x in val:
                    if '/' in x:
                        doclist.append((doc.docid,x))
                        #print(x)
        return doclist
    def countDocumentsOfGivenType(self, docName):
        c = 0
        for doc in self.documentList:
            Type = doc.docName.split('.')[1]
            if Type==docName:
                c+=1
        return c
n = int(input())
documents = []
for _ in range(n):
    docid = input()
    name = input()
    details = input()
    doc = Document(docid,name,details)
    documents.append(doc)
archive = DocumentArchive(10,documents)
for i in archive.findDateFromDocumentDetails():
    print(i[0],i[1])
docname = input()
print('Document Count =',archive.countDocumentsOfGivenType(docname))
