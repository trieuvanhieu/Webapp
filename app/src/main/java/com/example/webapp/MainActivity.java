package com.example.webapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private VideoView videoView;
    private EditText edtHoTen, edtMaSV;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        imageView = findViewById(R.id.imageView);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMaSV = findViewById(R.id.edtMaSV);
        videoView = findViewById(R.id.videoView);
        Button btnPlaySound = findViewById(R.id.btnPlaySound);
        Button btnStopSound = findViewById(R.id.btnStopSound);
        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnStopVideo = findViewById(R.id.btnStopVideo);

        // Khởi tạo MediaPlayer với file âm thanh
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio);

        // Xử lý phát âm thanh
        btnPlaySound.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });

        // Xử lý dừng âm thanh
        btnStopSound.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });

        // Xử lý phát video
        btnPlayVideo.setOnClickListener(v -> {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample_video);
            videoView.setVideoURI(videoUri);
            videoView.start();
        });

        // Xử lý dừng video
        btnStopVideo.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                videoView.seekTo(0);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
