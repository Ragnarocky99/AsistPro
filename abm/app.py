from flask import Flask,render_template
import mysql.connector

app = Flask(__name__)

# Configuración de la conexión a MySQL
db = mysql.connector.connect(
    host="localhost",
    user="",
    password="",
    database="bd_ctn"
)

# Ruta de inicio
@app.route('/')
def main():
    cursor = db.cursor()
    cursor.execute("SELECT * FROM tabla")
    data = cursor.fetchall()
    return render_template('main.html', data=data)

if __name__ == '__main__':
    app.run(debug=True)