# 🛡️ LiveGuard AI

![React](https://img.shields.io/badge/React-19-blue?logo=react)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green?logo=springboot)
![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Python](https://img.shields.io/badge/Python-3.11-blue?logo=python)
![FastAPI](https://img.shields.io/badge/FastAPI-0.115-green?logo=fastapi)
![PyTorch](https://img.shields.io/badge/PyTorch-AI-red?logo=pytorch)
![Vercel](https://img.shields.io/badge/Vercel-Deployed-black?logo=vercel)
![Render](https://img.shields.io/badge/Render-Deployed-purple)

---

## 📌 Overview

**LiveGuard AI** is an AI-powered video verification platform that detects manipulated, AI-generated, and contextually misleading videos.

The project follows a **microservice architecture** where a React frontend communicates with a Spring Boot backend, which delegates AI inference to a FastAPI-based Python service.

The platform performs multiple layers of verification to help users assess the authenticity of uploaded videos.

---

# 🌐 Live Demo

### Frontend

**liveguard-ai.vercel.app**

### Spring Boot Backend

**https://liveguard-backend-2.onrender.com**

### Python AI Service

**https://liveguard-python-ai-2.onrender.com**

---

# ✨ Features

## 🎭 Deepfake Detection

- Detects facial manipulation
- AI-powered feature analysis
- Deepfake risk estimation

---

## 🎬 Synthetic Media Detection

- Detects AI-generated videos
- Temporal artifact analysis
- Synthetic media risk scoring

---

## 🌍 Context Integrity Analysis

- Compares uploaded videos with user-provided claims
- Identifies scene-claim inconsistencies
- Environmental consistency verification
- Temporal reuse detection

---

## 📊 Risk Assessment

Each analysis provides:

- Risk Score
- Risk Level
- Detailed Summary
- Explainable Results

---

# 🏗️ System Architecture

```text
                    User
                      │
                      ▼
         React Frontend (Vercel)
                      │
             REST API Requests
                      │
                      ▼
      Spring Boot Backend (Render)
                      │
          Multipart HTTP Requests
                      │
                      ▼
      FastAPI AI Service (Render)
                      │
                      ▼
        AI Analysis Modules

      • Deepfake Detection
      • Synthetic Detection
      • Context Integrity Analysis
```

---

# 🚀 Workflow

1. User uploads a video through the React frontend.
2. Spring Boot receives and validates the upload.
3. The backend forwards the video to the Python AI service.
4. AI models analyze the uploaded video.
5. Risk scores are generated.
6. Spring Boot returns the analysis to the frontend.
7. Results are displayed to the user.

---

# 🛠️ Tech Stack

## Frontend

- React
- TypeScript
- Vite
- Tailwind CSS

## Backend

- Java 21
- Spring Boot
- REST API

## AI Service

- Python
- FastAPI
- PyTorch
- OpenCV
- Transformers (CLIP)
- NumPy

## Deployment

- Vercel
- Render
- GitHub

---

# 📂 Project Structure

```text
liveguard-ai/
│
├── frontend/                 # React Frontend
│
├── python-ai/                # FastAPI AI Service
│   ├── app.py
│   ├── analyze_deepfake.py
│   ├── analyze_synthetic.py
│   ├── analyze_context.py
│   ├── contextual_analysis.py
│   ├── temporal_analysis.py
│   └── requirements.txt
│
├── src/
│   ├── controller/
│   ├── service/
│   ├── dto/
│   └── config/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# ⚙️ Running Locally

## Clone Repository

```bash
git clone https://github.com/Yuvii77/liveguard-ai.git
```

---

## Frontend

```bash
cd frontend
npm install
npm run dev
```

---

## Spring Boot Backend

```bash
./mvnw spring-boot:run
```

---

## Python AI Service

```bash
cd python-ai
pip install -r requirements.txt
uvicorn app:app --reload
```

---

# 📸 Screenshots

> Add screenshots here.

Example:

```
screenshots/

home.png

upload.png

deepfake-result.png

synthetic-result.png

context-result.png
```

Then add:

```markdown
## Home

![Home](screenshots/home.png)

---

## Deepfake Detection

![Deepfake](screenshots/deepfake-result.png)

---

## Synthetic Detection

![Synthetic](screenshots/synthetic-result.png)

---

## Context Analysis

![Context](screenshots/context-result.png)
```

---

# 🚀 Future Enhancements

- Explainable AI visualizations
- Image verification support
- User authentication
- PDF report generation
- Batch video processing
- Video provenance tracking
- Model performance improvements

---

# 👨‍💻 Author

**Penta Yuvaraj**

GitHub

https://github.com/Yuvii77
