import psycopg2
from DB.config import config
from DB.student_table import student
class DB:
    def __init__(self):
        params = config()
        self.conn = psycopg2.connect(**params)
        self.cur = self.conn.cursor()
        self.student = student(self)
    def insert_students(self,student_data):
        # print(student_data)
        return self.student.create_student(student_data)
    def get_students(self):
        return self.student.get_students()
        # print(student_list)
        # return student_list
    def test(self):
        print("connected Succesfully!")