# 🚌 RedBus Automation Project

## 📌 Project Overview
This project demonstrates a real-world Selenium WebDriver automation framework built in Java to automate the RedBus booking website. It showcases dynamic element handling, JavaScript-assisted scrolling, intelligent waits, and location-based filtering logic—all developed using industry-standard best practices.

---

## 🚀 Features
- Automates source and destination selection using active element focus.
- Applies custom filters for **Primo Bus** and **Evening (18:00-24:00)** bus timings.
- Implements smooth scrolling until the “End of list” is reached.
- Extracts and logs bus names dynamically.
- Ensures graceful teardown using `document.readyState` before invoking `driver.quit()`.

---

## 🧪 Tech Stack
| Technology        | Description                            |
|-------------------|----------------------------------------|
| Java 11           | Programming language for core logic    |
| Selenium WebDriver| Browser automation                     |
| ChromeDriver      | Executing tests in Google Chrome       |
| JavaScriptExecutor| Scrolling and readiness validation     |
| WebDriverWait     | Smart, explicit waits for stability    |

---

## 🗂 Folder Structure
```plaintext
com.redbus/
├── RedBusAutomationProject.java
```

---

## 🧠 How It Works
1. Launches Chrome in maximized mode.
2. Opens [RedBus.in](https://www.redbus.in/) and automates city selection.
3. Applies filters (Primo + Evening).
4. Scrolls through the dynamically loaded list of buses.
5. Logs total buses and their names.
6. Performs a clean browser shutdown after checking page readiness.

---

## ✅ Prerequisites
- JDK 11 or above
- Maven or manually added Selenium dependencies
- Chrome browser with matching ChromeDriver

---

## 🧩 Sample Output
```
SRS Travels
Kaveri Travels
Orange Tours and Travels
...
Total no of Buses after applying primo and Evening filter: 34
```

---

## 🔒 Graceful Exit Strategy
Browser shutdown (`driver.quit()`) only occurs after:
```java
String readyState = js.executeScript("return document.readyState").toString();
if (readyState.equals("complete")) {
    driver.quit();
}
```

---

## 📌 Notes
- All locators are optimized using dynamic strategies.
- Exception handling and retry mechanisms can be added for robustness.
- Ideal for learning advanced Selenium concepts with real-world UI interactions.
