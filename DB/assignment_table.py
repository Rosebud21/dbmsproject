import psycopg2
class assignment:
    def __init__(self,DB):
        self.database = DB
    def create_assignment(self,assignment):
        sql_insert = "INSERT INTO "
        sql_insert+=  "assignments" 
        sql_insert+= "(subcode,title,description,deadline) VALUES(%s,%s,%s,%s);"
        try:
            self.database.cur.execute(sql_insert, (str(assignment["subcode"]),str(assignment["title"]),str(assignment["description"]),str(assignment["deadline"])) )
            self.database.conn.commit()
        except (psycopg2.DatabaseError) as error:
            print("error! = "+error)
            return False
        print("Inserted Successfully!")
        return True
        # return False
    def get_assignments(self,code):
        sql_get = "SELECT * FROM "
        sql_get+=  " assignments"
        sql_get+=  " WHERE subcode="
        sql_get+=code
        self.database.cur.execute(sql_get)
        table = self.database.cur.fetchall()
        assignment_list = []
        for row in table:
            assignment={}
            assignment["sno"] = row[0]
            assignment["subcode"] = row[1]
            assignment["title"] = row[2]
            assignment["description"] = row[3]
            assignment["deadline"] = row[4]
            assignment_list.append(assignment)
        return assignment_list