import psycopg2
from config import config
class DB:
    def __init__(self):
        params = config()
        self.conn = psycopg2.connect(**params)
        self.cur = self.conn.cursor()
    def create_student(self,student):
        sql_insert = "INSERT INTO "
        sql_insert+=  "student" 
        sql_insert+= "(name,rollnum,branch,year,password) VALUES(%s,%s,%s,%s,%s);"
        self.cur.execute(sql_insert, ( str(student["name"]),str(student["rollnum"]),str(student["branch"]),str(student["year"])),str(student["password"]) )
        self.conn.commit()
    def get_students(self):
        sql_get = "SELECT * FROM "
        sql_get+=  "student"
        self.cur.execute(sql_get)
        table = self.cur.fetchall()
        student_list = []
        for row in table:
            student={}
            student["name"] = row[0]
            student["rollnum"] = row[1]
            student["branch"] = row[2]
            student["year"] = row[3]
            student["password"] = row[4]
            student_list.append(student)
        # print(out)
        return student_list