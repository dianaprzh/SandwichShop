package co.mobilemaker.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by diany_000 on 1/27/2015.
 */
public class Sandwich implements Parcelable {

        ArrayList<String> sandwichOptions;
        public Sandwich(){
            sandwichOptions = new ArrayList<String>();
        }

        private Sandwich(Parcel source){
            this();
            source.readStringList(sandwichOptions);
        }

        public ArrayList<String> getResults() {
            return sandwichOptions;
        }

        public void setResults(ArrayList<String> sandwichOptions) {
            this.sandwichOptions = sandwichOptions;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeStringList(sandwichOptions);
        }

        public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>() {
            @Override
            public Sandwich createFromParcel(Parcel source) {
                return new Sandwich(source);
            }

            @Override
            public Sandwich[] newArray(int size) {
                return new Sandwich[size];
            }
        };


}
