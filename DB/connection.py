import psycopg2
from DB.config import config
from DB.student_table import student
from DB.faculty_table import faculty
from DB.assignment_table import assignment
from DB.material_table import material
class DB:
    def __init__(self):
        params = config()
        self.conn = psycopg2.connect(**params)
        self.cur = self.conn.cursor()
        self.student = student(self)
        self.faculty = faculty(self)
        self.assignments = assignment(self)
        self.material = material(self)

# student table handler
    def insert_students(self,student_data):
        return self.student.create_student(student_data)
    def get_students(self):
        return self.student.get_students()

# faculty table handler
    def get_faculty(self):
        return self.faculty.get_faculty()

# assignments table handler
    def create_assignments(self,assignment):
        return self.assignments.create_assignment(assignment)
    def get_assignments(self,subcode):
        return self.assignments.get_assignments(subcode)

# material table handler
    def create_material(self,material):
        return self.material.create_materials(material)
    def get_material(self,subcode):
        return self.material.get_materials(subcode)
        
# testing handler
    def test(self):
        print("connected Succesfully!")