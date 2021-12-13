from flask import Flask
from flask import request
import flask
from werkzeug.wrappers import response
from DB.assignment_table import assignment
from DB.connection import DB
database = DB()
app = Flask(__name__)

@app.route('/hello/', methods=['GET', 'POST'])
def welcome():
    return "Hello World!"



@app.route('/student/getall/', methods=['GET'])
def get_students():
    out = ""
    # print(request.headers['Subcode'])
    for student in database.get_students():
        out += str(student['name']).replace(" ","-")+" "
        out += str(student['rollnum']).replace(" ","-")+" "
        out += str(student['year']).replace(" ","-")+" "
        out += str(student['grade']).replace(" ","-")+" "
        out += str(student['attendance']).replace(" ","-")+" "
        out += str(student['branch']).replace(" ","-")+"\n"
    res =  flask.Response(out)
    return res
@app.route('/student/login/', methods=['GET', 'POST'])
def slogin():
    for students in database.get_students():
        if(request.args.to_dict(flat=False)['id'][0]==students['rollnum'] and request.args.to_dict(flat=False)['pass'][0]==students['password']):
            res =  flask.Response("True")
            res.headers['name'] = students['name']
            res.headers['rollnumber'] = students['rollnum']
            res.headers['password'] = students['password']
            res.headers['year'] = students['year']
            res.headers['branch'] = students['branch']
            print("Valid Login!!")
            return res
    res =  flask.Response("False")
    print("Invalid Login!!")
    return res
@app.route('/student/signup/', methods=['GET', 'POST'])
def test():
    students={}
    students['rollnum'] = request.args.to_dict(flat=False)['rollnum'][0]
    students['name'] = request.args.to_dict(flat=False)['name'][0]
    students['password'] = request.args.to_dict(flat=False)['password'][0]
    students['year'] = request.args.to_dict(flat=False)['year'][0]
    students['branch'] = request.args.to_dict(flat=False)['branch'][0]
    return str(database.insert_students(students))




@app.route('/faculty/login/', methods=['GET', 'POST'])
def flogin():
    for faculty in database.get_faculty():
        if(request.args.to_dict(flat=False)['eid'][0]==faculty['eid'] and request.args.to_dict(flat=False)['pass'][0]==faculty['password']):
            res =  flask.Response("True")
            res.headers['name'] = faculty['name']
            res.headers['eid'] = faculty['eid']
            res.headers['password'] = faculty['password']
            res.headers['branch'] = faculty['branch']
            print("Valid Login!!")
            return res
    res =  flask.Response("False")
    print("Invalid Login!!")
    return res




@app.route('/assignments/', methods=['GET'])
def get_assignments():
    out = ""
    # print(request.headers['Subcode'])
    for assignment in database.get_assignments("'"+request.args.to_dict(flat=False)['subcode'][0].replace("-"," ")+"'"):
        out += str(assignment['sno']).replace(" ","-")+" "
        out += str(assignment['subcode']).replace(" ","-")+" "
        out += str(assignment['title']).replace(" ","-")+" "
        out += str(assignment['description']).replace(" ","-")+" "
        out += str(assignment['deadline']).replace(" ","-")+"\n"
    res =  flask.Response(out)
    return res
@app.route('/assignments/', methods=['POST'])
def Create_assignments():
    assignment = {}
    assignment['subcode'] = request.headers['Subcode']
    assignment['title'] = request.headers['Title']
    assignment['description'] = request.headers['Description']
    assignment['deadline'] = request.headers['Deadline']
    # print(assignment)
    return str(database.create_assignments(assignment))


@app.route('/material/', methods=['GET'])
def get_materials():
    out = ""
    # print(request.headers['Subcode'])
    for material in database.get_material("'"+request.headers['Subcode']+"'"):
        out += str(material['sno']).replace(" ","-")+" "
        out += str(material['subcode']).replace(" ","-")+" "
        out += str(material['filename']).replace(" ","-")+" "
        out += str(material['date']).replace(" ","-")+"\n"
    res =  flask.Response(out)
    return res
@app.route('/material/', methods=['POST'])
def Create_materials():
    material = {}
    material['subcode'] = request.headers['Subcode']
    material['filename'] = request.headers['Filename']
    material['date'] = request.headers['Date']
    return str(database.create_material(material))

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5499)
