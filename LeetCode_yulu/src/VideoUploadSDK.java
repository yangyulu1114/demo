public class VideoUploadSDK {

    static VideoUploader getVideoUploader() {
//        return new VideoUploaderImpl1();
        return new VideoUploaderImpl2();
    }

    private static class VideoUploaderImpl1 implements VideoUploader {

        @Override
        public void upload(String videoPath) {

        }

        @Override
        public void cancel() {

        }
    }

    private static class VideoUploaderImpl2 implements VideoUploader {

        @Override
        public void upload(String videoPath) {

        }

        @Override
        public void cancel() {

        }
    }
}
