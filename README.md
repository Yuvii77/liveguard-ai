# LiveGuard AI

LiveGuard AI is a full-stack video verification platform that helps identify potentially manipulated, AI-generated, or contextually misleading videos.

The application combines a React frontend, Spring Boot backend, and Python AI services to perform multiple layers of video analysis.

---

## Features

### Deepfake Detection
Analyzes uploaded videos for signs of facial manipulation and synthetic alterations.

### Synthetic Media Detection
Detects AI-generated content using temporal feature analysis and statistical artifact detection.

### Context Integrity Analysis
Compares user-provided claims with video content and identifies possible scene-claim mismatches.

### Risk Assessment
Provides:
- Risk Score
- Risk Level
- Detailed Analysis Summary

---

## Tech Stack

### Frontend
- React
- TypeScript
- Vite
- Tailwind CSS

### Backend
- Java
- Spring Boot

### AI Service
- Python
- FastAPI
- PyTorch
- OpenCV
- Transformers (CLIP)

---

## Architecture

```text
React Frontend
      │
      ▼
Spring Boot Backend
      │
      ▼
Python FastAPI AI Service
      │
      ▼
Video Analysis Modules

- Deepfake Detection
- Synthetic Media Detection
- Context Integrity Analysis
```

## Project Structure

```text
liveguard/
│
├── frontend/
│
├── python-ai/
│   ├── app.py
│   ├── analyze_deepfake.py
│   ├── analyze_synthetic.py
│   ├── analyze_context.py
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

## How To Run

### Python AI Service

```bash
cd python-ai
uvicorn app:app --reload --port 8000
```

### Spring Boot Backend

```bash
.\mvnw.cmd spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Open:

```text
http://localhost:3000
```

---

## Future Enhancements

- Cloud deployment
- User authentication
- Analysis history
- Report generation
- Real-time video streams
