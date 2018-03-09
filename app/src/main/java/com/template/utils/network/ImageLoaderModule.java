package com.template.utils.network;

import android.content.Context;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ImageLoaderModule {
    public static void loadImage(Context context, String url, ImageView imageView, int placeholder, boolean caching, final ImageLoaderListener listener) {
        Callback callback = new Callback() {
            @Override
            public void onSuccess() {
                if (listener != null) {
                    listener.onImageLoaded();
                }
            }

            @Override
            public void onError() {
                if (listener != null) {
                    listener.onImageLoaded();
                }
            }
        };
        if (url != null) {
            if (caching) {
                if (placeholder > -1) {
                    Picasso.with(context).load(url).placeholder(placeholder).into(imageView, callback);
                } else {
                    Picasso.with(context).load(url).into(imageView, callback);
                }
            } else {
                if (placeholder > -1) {
                    Picasso.with(context).load(url).memoryPolicy(MemoryPolicy.NO_CACHE).placeholder(placeholder).into(imageView, callback);
                } else {
                    Picasso.with(context).load(url).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView, callback);
                }
            }
        }
    }


    public interface ImageLoaderListener {
        void onImageLoaded();

        void onLoadingStarted();
    }
}