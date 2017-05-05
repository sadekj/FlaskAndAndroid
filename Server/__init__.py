from flask import *
import db
app = Flask(__name__)
@app.route("/signin")
def index():
	db.search(request.json['username'])
	return "{username}"
	# return "{username:'omar',password:'adam'}"

if __name__ == "__main__":
    app.run(host="0.0.0.0")
