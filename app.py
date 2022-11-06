from flask import Flask,request,jsonify

#Flask 객체 인스턴스 생성

app = Flask(__name__)


# 접속 url 설정
@app.route('/hello_world')
def hello_world():
    return 'Hello, World!'

@app.route('/echo_call/<param>')
def get_echo_call(param):
    return jsonify({"param":param})
@app.route('/echo_call', methods=['POST']) #post echo api
def post_echo_call():
    param= request.get_json()
    return jsonify(param)
if __name__ == '__main__':
    #코드 수정 시 자동 반영
    app.run()
