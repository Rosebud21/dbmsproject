from flask import Flask
from flask import request
import flask
from werkzeug.wrappers import response
from DB.connection import DB
database = DB()
app = Flask(__name__)

@app.route('/hello/', methods=['GET', 'POST'])
def welcome():
    return "Hello World!"

@app.route('/student/login/', methods=['GET', 'POST'])
def slogin():
    # print("id = ",request.args.to_dict(flat=False)['id'][0])
    # print("pass = ",request.args.to_dict(flat=False)['pass'][0])
    # print(database.get_students())
    for students in database.get_students():
        # print(request.args.to_dict(flat=False)['id'][0],students['rollnum'],request.args.to_dict(flat=False)['id'][0]==students['rollnum'])
        # print(request.args.to_dict(flat=False)['pass'][0]==students['password'])
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

# @app.route()
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5499)
