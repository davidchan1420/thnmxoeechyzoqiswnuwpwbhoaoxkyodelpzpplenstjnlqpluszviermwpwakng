package movieservice.domain;

import java.io.Serializable;
import java.util.Calendar;

import android.os.Parcel;
import android.os.Parcelable;
import movieservice.util.Coordinate;

public class Movie implements Parcelable, Serializable {

	private static final long serialVersionUID = -5378086385821148068L;

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(movieName);
		dest.writeString(cinema);
		dest.writeSerializable(showingDate);
//		dest.writeInt(fee == null ? 0 : fee);
		dest.writeValue(fee);
		dest.writeParcelable(coordinate, flags);
//		dest.writeDouble(relativeDistance == null ? 0D : relativeDistance);
		dest.writeValue(relativeDistance);
	}

	public Movie(Parcel in) {
         movieName = in.readString();
         cinema = in.readString();
         showingDate = (Calendar) in.readSerializable();
//         fee = (in.readInt() == 0 ? null : in.readInt());
         fee = (Integer) in.readValue(Movie.class.getClassLoader());         
         coordinate = in.readParcelable(Movie.class.getClassLoader());
//         relativeDistance = (in.readDouble() == 0D ? null : in.readDouble());
         relativeDistance = (Double) in.readValue(Movie.class.getClassLoader());
    }

	public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
		public Movie createFromParcel(Parcel in) {
			return new Movie(in);
		}

		public Movie[] newArray(int size) {
			return new Movie[size];
		}
	};	


	private String movieName;
	private String cinema;
	private Calendar showingDate;
	private Integer fee;

//	private Double x;
//	private Double y;
	public Coordinate coordinate;


	private Double relativeDistance;
	
	public Movie(){}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

//	public Timestamp getShowingDate() {
//		return showingDate;
//	}
//	public void setShowingDate(Timestamp showingDate) {
//		this.showingDate = showingDate;
//	}

	public Calendar getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(Calendar showingDate) {
		this.showingDate = showingDate;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

//	public Double getX() {
//		return x;
//	}
//	public void setX(Double x) {
//		this.x = x;
//	}
//	public Double getY() {
//		return y;
//	}
//	public void setY(Double y) {
//		this.y = y;
//	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setRelativeDistance(Double distance) {
		this.relativeDistance = distance;
	}

	public Double getRelativeDistance() {
		return relativeDistance;
	}

}
