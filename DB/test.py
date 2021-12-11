import psycopg2
from config import config
params = config()
conn = psycopg2.connect(**params)
cur = conn.cursor()
def GetTableList():
        s = ""
        s += "SELECT"
        s += " table_schema"
        s += ", table_name"
        s += " FROM information_schema.tables"
        s += " WHERE"
        s += " ("
        s += " table_schema = 'public'"
        s += " )"
        s += " ORDER BY table_schema, table_name;"
        cur.execute(s)
        list_tables = cur.fetchall()
        print(list_tables)
# GetTableList()
def create_student_table():
    command = "CREATE TABLE "
    command+= "student" 
    command+=" ("
    command+=" name VARCHAR(32) NOT NULL,"
    command+=" rollnum VARCHAR(255) NOT NULL PRIMARY KEY,"
    command+=" branch VARCHAR(32) NOT NULL,"
    command+=" year VARCHAR(32) NOT NULL,"
    command+=" password VARCHAR(32) NOT NULL"
    command+=" )"
    cur.execute(command)
    conn.commit()
# create_student_table()
def add_dummy_students():
    sql_insert = "INSERT INTO "
    sql_insert+=  "student" 
    sql_insert+= "(name,rollnum,branch,year,password) VALUES(%s,%s,%s,%s,%s);"
    cur.execute(sql_insert,("Sneha","102","CSE","2","xxx"))
    cur.execute(sql_insert,("Sahithi","103","EEE", 2,"xxx"))
    conn.commit()
# add_dummy_students()
def get_students():
        sql_get = "SELECT * FROM "
        sql_get+=  "student"
        cur.execute(sql_get)
        table = cur.fetchall()
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
        print(student_list)
# get_students()
def create_faculty_table():
    command = "CREATE TABLE "
    command+= "faculty" 
    command+=" ("
    command+=" name VARCHAR(32) NOT NULL,"
    command+=" eid VARCHAR(255) NOT NULL PRIMARY KEY,"
    command+=" branch VARCHAR(32) NOT NULL,"
    command+=" password VARCHAR(32) NOT NULL"
    command+=" )"
    cur.execute(command)
    conn.commit()
create_faculty_table()
# GetTableList()
def add_dummy_faculty():
    sql_insert = "INSERT INTO "
    sql_insert+=  "faculty" 
    sql_insert+= "(name,eid,branch,password) VALUES(%s,%s,%s,%s);"
    cur.execute(sql_insert,("fac1","001","CSE","yyy"))
    cur.execute(sql_insert,("fac2","002","EEE","yyy"))
    conn.commit()
add_dummy_faculty()

def create_assignment_table():
    # subcode,title,desciption,deadline
    command = "CREATE TABLE "
    command+= "assignments" 
    command+=" ("
    command+=" sno SERIAL PRIMARY KEY,"
    # command+=" branch VARCHAR(32) NOT NULL,"
    command+=" subcode VARCHAR(32) NOT NULL,"
    command+=" title VARCHAR(255) NOT NULL,"
    command+=" description VARCHAR(255) NOT NULL,"
    command+=" deadline VARCHAR(32) NOT NULL"
    command+=" )"
    cur.execute(command)
    conn.commit()
create_assignment_table()
GetTableList()
def add_dummy_assignment():
    sql_insert = "INSERT INTO "
    sql_insert+=  "assignments" 
    sql_insert+= "(subcode,title,description,deadline) VALUES(%s,%s,%s,%s);"

    cur.execute(sql_insert,("CS 202","CSE-homework 1", "Submit tutorial", "10 May"))
    cur.execute(sql_insert,("CS 202","CSE-homework 2", "Lab assignment" , "20 May"))
    cur.execute(sql_insert,("CS 202","CSE-homework 3", "Lab assignment" , "29 May"))

    cur.execute(sql_insert,("CS 203","CSE-homework 1", "Submit tutorial", "10 May"))
    cur.execute(sql_insert,("CS 203","CSE-homework 2", "Lab assignment" , "20 May"))
    cur.execute(sql_insert,("CS 203","CSE-homework 3", "Lab assignment" , "29 May"))

    cur.execute(sql_insert,("CS 204","CSE-homework 1", "Submit tutorial", "10 May"))
    cur.execute(sql_insert,("CS 204","CSE-homework 2", "Lab assignment" , "20 May"))
    cur.execute(sql_insert,("CS 204","CSE-homework 3", "Lab assignment" , "29 May"))

    cur.execute(sql_insert,("CS 205","CSE-homework 2", "Lab assignment" , "20 May"))
    cur.execute(sql_insert,("CS 205","CSE-homework 3", "Lab assignment" , "29 May"))

    cur.execute(sql_insert,("ES 211","CSE-homework 2", "Lab assignment" , "20 May"))
    cur.execute(sql_insert,("ES 204","CSE-homework 3", "Lab assignment" , "29 May"))
    
    cur.execute(sql_insert,("EE 205","ECE-homework 1", "Submit tutorial", "11 May"))
    cur.execute(sql_insert,("EE 205","ECE-homework 2", "Lab assignment" , "21 May"))
    cur.execute(sql_insert,("EE 205","ECE-homework 3", "Lab assignment" , "30 May"))
    conn.commit()
add_dummy_assignment()










def create_subjects_table():
    command = "CREATE TABLE "
    command+= "subjects" 
    command+=" ("
    command+=" name VARCHAR(32) NOT NULL"
    command+=" code VARCHAR(255) NOT NULL PRIMARY KEY,"
    command+=" branch VARCHAR(32) NOT NULL"
    command+=" year VARCHAR(32) NOT NULL"
    command+=" )"
    cur.execute(command)
    conn.commit()






    #primary key needs to be set
def create_faculty_subjects_table():
    command = "CREATE TABLE "
    command+= "faculty_subjects" 
    command+=" ("
    command+=" code VARCHAR(32) NOT NULL"
    command+=" eid VARCHAR(255) NOT NULL"
    command+=" )"
    cur.execute(command)
    conn.commit()



    