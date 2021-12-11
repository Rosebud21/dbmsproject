import psycopg2
class faculty:
    def __init__(self,DB):
        self.database = DB
    def create_faculty(self,faculty):
        sql_insert = "INSERT INTO "
        sql_insert+=  "faculty" 
        sql_insert+= "(name,eid,branch,password) VALUES(%s,%s,%s,%s);"
        try:
            self.database.cur.execute(sql_insert, ( str(faculty["name"]),str(faculty["eid"]),str(faculty["branch"]),str(faculty["password"])) )
            self.database.conn.commit()
        except (psycopg2.DatabaseError) as error:
            print("error! = "+error)
            return False
        print("Inserted Successfully!")
        return True
        # return False
    def get_faculty(self):
        sql_get = "SELECT * FROM "
        sql_get+=  "faculty"
        self.database.cur.execute(sql_get)
        table = self.database.cur.fetchall()
        faculty_list = []
        for row in table:
            faculty={}
            faculty["name"]      = row[0]
            faculty["eid"]   = row[1]
            faculty["branch"]    = row[2]
            faculty["password"]  = row[3]
            faculty_list.append(faculty)
        # print(out)
        return faculty_list