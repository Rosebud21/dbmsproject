import psycopg2
class material:
    def __init__(self,DB):
        self.database = DB
    def create_materials(self,material):
        print(material)
        sql_insert = "INSERT INTO "
        sql_insert+=  "material" 
        sql_insert+= " (subcode,filename,date) VALUES(%s,%s,%s);"
        try:
            self.database.cur.execute(sql_insert, (str(material["subcode"]),str(material["filename"]),str(material["date"])) )
            self.database.conn.commit()
        except (psycopg2.DatabaseError) as error:
            print("error! = "+error)
            return False
        print("Inserted Successfully!")
        return True
        # return False
    def get_materials(self,code):
        sql_get = "SELECT * FROM "
        sql_get+=  " material"
        sql_get+=  " WHERE subcode="
        sql_get+=code
        self.database.cur.execute(sql_get)
        table = self.database.cur.fetchall()
        material_list = []
        for row in table:
            material={}
            material["sno"] = row[0]
            material["subcode"] = row[1]
            material["filename"] = row[2]
            material["date"] = row[3]
            material_list.append(material)
        return material_list