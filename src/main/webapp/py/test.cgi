import cgi, json

payload = form['payload'].value
myjson = json.loads(payload)

for thing in myjson:
    print thing

sys.exit()