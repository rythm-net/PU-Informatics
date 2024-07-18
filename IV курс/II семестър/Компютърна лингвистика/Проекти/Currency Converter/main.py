# This is a sample Python script.
from flask import Flask, request, jsonify
from flask_cors import CORS
import re

app = Flask(__name__)
CORS(app)
USD_TO_EUR_RATE = 0.93
regExp = r"\$ *(\d+(\.\d+)?)"


@app.route('/convert', methods=['POST'])
def convert_currency():
    data = request.json
    text = data.get('text', '')

    def replace_price(match):
        usd_price = float(match.group(1))
        eur_price = usd_price * USD_TO_EUR_RATE
        return f"EUR {eur_price}"

    updated_text = re.sub(regExp, replace_price, text)
    return jsonify({"converted_text": updated_text})


app.run(debug=True, host="0.0.0.0", port=5000)


