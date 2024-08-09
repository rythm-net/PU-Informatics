import requests
import json

# URL of the service
url = "http://localhost:1234/v1/chat/completions"

# Headers
headers = {
    "Content-Type": "application/json"
}

# Data payload
data = {
    "messages": [
        {"role": "user", "content": "Write a python function which prints hello world."}
    ],
    "temperature": 0.7,
    "max_tokens": -1,
    "stream": False
}

# Make the POST request
response = requests.post(url, headers=headers, data=json.dumps(data))

# Check if the request was successful
if response.status_code == 200:
    print("Response from server:", response.json()["choices"][0])
else:
    print(f"Error: Received status code {response.status_code}")
