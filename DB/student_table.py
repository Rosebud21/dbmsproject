import psycopg2
class student:
    def __init__(self,DB):
        self.database = DB
    def create_student(self,student):
        sql_insert = "INSERT INTO "
        sql_insert+=  "student" 
        sql_insert+= "(name,rollnum,branch,year,password) VALUES(%s,%s,%s,%s,%s);"
        try:
            self.database.cur.execute(sql_insert, ( str(student["name"]),str(student["rollnum"]),str(student["branch"]),str(student["year"]),str(student["password"])) )
            self.database.conn.commit()
        except (psycopg2.DatabaseError) as error:
            print("error! = "+error)
            return False
        print("Inserted Successfully!")
        return True
        # return False
    def get_students(self):
        sql_get = "SELECT * FROM "
        sql_get+=  "student"
        self.database.cur.execute(sql_get)
        table = self.database.cur.fetchall()
        student_list = []
        for row in table:
            student={}
            student["name"] = row[0]
            student["rollnum"] = row[1]
            student["branch"] = row[2]
            student["year"] = row[3]
            student["password"] = row[4]
            student["grade"] = row[5]
            student["attendance"] = row[6]
            student_list.append(student)
        # print(out)
        return student_list