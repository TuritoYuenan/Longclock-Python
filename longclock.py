from datetime import datetime, timedelta, timezone
from dotenv import dotenv_values
import requests

####################################################
URL = 'https://api.api-ninjas.com/v1/geocoding?country={}&city={}'
APIkey = dotenv_values('secrets.env')['APIKEY']
####################################################

def geocode(country: str, city: str) -> dict:
	"Geocode a location based on the city and country"

	response = requests.get(
		url = URL.format(country, city),
		headers = {'X-Api-Key': APIkey}
	)

	if response.status_code == requests.codes.ok:
		output = response.json()[0]

		print(output)
		return output

	else:
		print("Error:", response.status_code, response.text)

####################################################
UTCtime = datetime.now(timezone.utc)
debugTimeFormat: str = '%Y-%m-%d %H:%M:%S'
####################################################

def clock(longitude: float) -> datetime:
	"Return time based on longitude"

	offset: int = timedelta(hours = round(longitude / 15))
	longtime = datetime.now(timezone(offset))

	return longtime

print(UTCtime.strftime(debugTimeFormat))
print(clock(108).strftime(debugTimeFormat))
