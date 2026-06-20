from fastapi import FastAPI, UploadFile, File, Form

from video_utils import (
    save_uploaded_video,
    validate_video,
    extract_frames,
    cleanup_temp_files
)

from analyze_deepfake import analyze_deepfake_risk
from analyze_context import analyze_context_integrity
from analyze_synthetic import analyze_synthetic_video

app = FastAPI()


@app.get("/")
def home():
    return {
        "service": "LiveGuard Python AI",
        "status": "running"
    }


@app.post("/analyze/deepfake")
async def analyze_deepfake(
        video: UploadFile = File(...)
):
    temp_video = None
    frame_paths = []

    try:

        content = await video.read()

        temp_video = save_uploaded_video(
            content,
            video.filename
        )

        is_valid, message = validate_video(temp_video)

        if not is_valid:
            return {
                "riskScore": 0,
                "riskLevel": "ERROR",
                "summary": message
            }

        frame_paths = extract_frames(temp_video)

        result = analyze_deepfake_risk(
            frame_paths
        )

        return result

    except Exception as e:

        return {
            "riskScore": 0,
            "riskLevel": "ERROR",
            "summary": str(e)
        }

    finally:

        cleanup_temp_files(frame_paths)


@app.post("/analyze/context")
async def analyze_context(
        video: UploadFile = File(...),
        claim: str = Form(...)
):
    temp_video = None
    frame_paths = []

    try:

        content = await video.read()

        temp_video = save_uploaded_video(
            content,
            video.filename
        )

        is_valid, message = validate_video(temp_video)

        if not is_valid:
            return {
                "riskScore": 0,
                "riskLevel": "ERROR",
                "summary": message
            }

        frame_paths = extract_frames(temp_video)

        result = analyze_context_integrity(
            frame_paths,
            claim
        )

        return result

    except Exception as e:

        return {
            "riskScore": 0,
            "riskLevel": "ERROR",
            "summary": str(e)
        }

    finally:

        cleanup_temp_files(frame_paths)


@app.post("/analyze/synthetic")
async def analyze_synthetic(
        video: UploadFile = File(...)
):
    temp_video = None
    frame_paths = []

    try:

        content = await video.read()

        temp_video = save_uploaded_video(
            content,
            video.filename
        )

        is_valid, message = validate_video(temp_video)

        if not is_valid:
            return {
                "riskScore": 0,
                "riskLevel": "ERROR",
                "summary": message
            }

        frame_paths = extract_frames(temp_video)

        result = analyze_synthetic_video(
            frame_paths
        )

        return result

    except Exception as e:

        return {
            "riskScore": 0,
            "riskLevel": "ERROR",
            "summary": str(e)
        }

    finally:

        cleanup_temp_files(frame_paths)