import psycopg2
from DB.config import config
from DB.student_table import student
from DB.faculty_table import faculty
from DB.assignment_table import assignment
class DB:
    def __init__(self):
        params = config()
        self.conn = psycopg2.connect(**params)
        self.cur = self.conn.cursor()
        self.student = student(self)
        self.faculty = faculty(self)
        self.assignments = assignment(self)
    def insert_students(self,student_data):
        # print(student_data)
        return self.student.create_student(student_data)
    def get_students(self):
        return self.student.get_students()
        # print(student_list)
        # return student_list

    def get_faculty(self):
        return self.faculty.get_faculty()

    def create_assignments(self,assignment):
        return self.assignments.create_assignment(assignment)
    def get_assignments(self,subcode):
        return self.assignments.get_assignments(subcode)

        
    def test(self):
        print("connected Succesfully!")