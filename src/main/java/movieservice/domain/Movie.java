package movieservice.domain;

import java.io.Serializable;
import java.util.Calendar;

import movieservice.util.Coordinate;
import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable, Serializable {

	private static final long serialVersionUID = 5505282358443423417L;

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(movieName);
		dest.writeString(cinema);
		dest.writeSerializable(showingDate);
		dest.writeValue(fee);
		dest.writeValue(normalSeat);
		dest.writeValue(vibratingSeat);
		dest.writeValue(wheelChairSeat);
		dest.writeParcelable(coordinate, flags);
		dest.writeValue(relativeDistance);
	}

	public Movie(Parcel in) {
		movieName = in.readString();
		cinema = in.readString();
		showingDate = (Calendar) in.readSerializable();
		fee = (Integer) in.readValue(Movie.class.getClassLoader());

		normalSeat = (Integer) in.readValue(Movie.class.getClassLoader());
		vibratingSeat = (Integer) in.readValue(Movie.class.getClassLoader());
		wheelChairSeat = (Integer) in.readValue(Movie.class.getClassLoader());

		coordinate = in.readParcelable(Movie.class.getClassLoader());
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
	private Integer normalSeat;
	private Integer vibratingSeat;
	private Integer wheelChairSeat;

	// private Double x;
	// private Double y;
	public Coordinate coordinate;
	private Double relativeDistance;

	public Movie() {

	}

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

	// public Timestamp getShowingDate() {
	// return showingDate;
	// }
	// public void setShowingDate(Timestamp showingDate) {
	// this.showingDate = showingDate;
	// }

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

	public Integer getNormalSeat() {
		return normalSeat;
	}

	public void setNormalSeat(Integer normalSeat) {
		this.normalSeat = normalSeat;
	}

	public Integer getVibratingSeat() {
		return vibratingSeat;
	}

	public void setVibratingSeat(Integer vibratingSeat) {
		this.vibratingSeat = vibratingSeat;
	}

	public Integer getWheelChairSeat() {
		return wheelChairSeat;
	}

	public void setWheelChairSeat(Integer wheelChairSeat) {
		this.wheelChairSeat = wheelChairSeat;
	}

	// public Double getX() {
	// return x;
	// }
	// public void setX(Double x) {
	// this.x = x;
	// }
	// public Double getY() {
	// return y;
	// }
	// public void setY(Double y) {
	// this.y = y;
	// }
	
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
