import dataset
db = dataset.connect('sqlite:///:memory:')
def tempdata():
	table = db['sometable']
	table.insert(dict(username="laith is here",password='passkey',email='emailkey'))
def search(user):
	table = db['sometable']
	john=table.find_one[username]
	return john

tempdata()
