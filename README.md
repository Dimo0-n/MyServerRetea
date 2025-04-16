# 🧨 Java HTTP Server – Spring Boot

## 🔥 Descriere

Server Java construit cu Spring Boot care primește requesturi HTTP de la un client și răspunde cu ce trebuie.  
Este piesa centrală a aplicației.

---

## 📦 Ce face

- Expune endpointuri REST.
- Primește requesturi de tip `GET`, `POST`, `PUT`, `DELETE`.
- Procesează body-uri JSON și răspunde cu statusuri și mesaje clare.
- E construit modular și ușor de extins dacă vrei să adaugi logică mai serioasă.

---

## 🚀 Cum îl folosești

1. **Clonează proiectul**
   ```bash
   git clone https://github.com/Dimo0-n/MyServerRetea.git
   cd MyServerRetea
   ```

2. **Build & Run (cu Maven)**
   Sau direct din IDE (IntelliJ, Eclipse): rulează clasa `HttpAppApplication`.

3. **Aplicația va rula pe portul `8080`**  
   Endpointuri disponibile (exemple):

   ![image](https://github.com/user-attachments/assets/88bdeeb6-83b5-4f54-bfb9-c7d34248ea55)

---

## 🔗 Legătură cu clientul

Clientul HTTP trimite requesturi către acest server.  
Dacă serverul nu e pornit sau dă eroare, clientul se uită în aer.

📍 Link către client:  
👉 [MyClientHttp](https://github.com/Dimo0-n/MyClientHttp)

Asigură-te că serverul e funcțional **înainte** să rulezi clientul.

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Maven

---

## 📍 Baza de date (MySQL only)

Aplicația are nevoie de conectare la o bază de date MySQL.  
Configurările sunt în `application.properties`. Dacă vrei, le poți modifica după cum ai nevoie.

![image](https://github.com/user-attachments/assets/632e3b9a-eabe-4fda-8b08-02ab886adcd7)

### 🐳 Docker MySQL

Dacă nu vrei să-ți bați capul local, poți rula baza de date într-un container Docker:

```bash
docker run --name my-sql-bd -e MYSQL_ROOT_PASSWORD=qwertyuiop -p 3312:3306 -d mysql:latest
```

Asigură-te că ai setat portul, parola și numele DB corect în aplicație.

---

## 🔥 Spor la configurare

Dacă serverul nu merge, nu dispera. Uită-te în loguri, vezi ce spune și repară.  
Când merge, nu te mai atinge de el — lasă-l să-și facă treaba.  
Clientul depinde de el. Fără server, clientul sta degeaba
