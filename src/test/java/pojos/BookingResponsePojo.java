package pojos;

public class BookingResponsePojo {

private Integer bookingid;
private BookingPojo booking ;

    public BookingResponsePojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponsePojo() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }

    /*
    {
        "bookingid": 16,
            "booking" :{
        "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
        }
        "additionalneeds": "Breakfast"
    }
    }
     */



}
