package com.huwei.sweetmusicplayer.data.models;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import android.net.Uri;
import android.os.Parcel;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.huwei.sweetmusicplayer.SweetApplication;
import com.huwei.sweetmusicplayer.util.CharacterParser;
import com.huwei.sweetmusicplayer.util.MusicUtils;

import java.io.File;

/**
 * Entity mapped to table MUSIC_INFO.
 */
public class MusicInfo extends AbstractMusic {

    private Long songId;
    private Long albumId;
    private Long artistId;
    private String title;
    private String artist;
    private Integer duration;
    private String path;
    private Boolean favorite;

    public MusicInfo() {
    }

    public MusicInfo(Long songId, Long albumId, Long artistId, String title, String artist, Integer duration, String path, Boolean favorite) {
        this.songId = songId;
        this.albumId = albumId;
        this.artistId = artistId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.path = path;
        this.favorite = favorite;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String getArtPic() {
        String artPath = MusicUtils.getAlbumArtPath(SweetApplication.CONTEXT, albumId);
        if (TextUtils.isEmpty(artPath)) return "";
        Uri uri = Uri.fromFile(new File(artPath));
        return uri.toString();
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * define by myself
     */
    public static final Byte ISFAVORITE = 1;
    public static final Byte NOTFAVORITE = 0;

    public MusicInfo(Parcel parcel) {
        super();

        this.songId = parcel.readLong();
        this.albumId = parcel.readLong();
        this.artistId = parcel.readLong();
        this.title = parcel.readString();
        this.artist = parcel.readString();
        this.duration = parcel.readInt();
        this.path = parcel.readString();
        this.favorite = parcel.readByte() == ISFAVORITE;
    }

    @Override
    public int blurValueOfPlaying() {
        return 120;
    }

    /**
     * 获取title的首字母
     *
     * @return
     */
    public String getKeyofTitle() {
        return CharacterParser.getFirstUpperLetter(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(songId);
        dest.writeLong(albumId);
        dest.writeLong(artistId);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeInt(duration);
        dest.writeString(path);
        dest.writeByte(favorite ? ISFAVORITE : NOTFAVORITE);
    }


    @Override
    public Uri getDataSoure() {
        return Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "" + getSongId());
    }

    @Override
    public AbstractMusic.MusicType getType() {
        return AbstractMusic.MusicType.Local;
    }

    @Override
    public MusicInfo createFromParcel(Parcel source) {
        return new MusicInfo(source);
    }

    @Override
    public MusicInfo[] newArray(int size) {
        return new MusicInfo[size];
    }

    public static final Creator<MusicInfo> CREATOR = new Creator<MusicInfo>() {
        public MusicInfo createFromParcel(Parcel source) {
            return new MusicInfo(source);
        }

        public MusicInfo[] newArray(int size) {
            return new MusicInfo[size];
        }
    };
}
