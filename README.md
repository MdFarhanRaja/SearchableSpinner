# SearchableSpinner
Fully Searchable Spiner Dialog

![Screen Shot](https://cloud.githubusercontent.com/assets/18304656/23259376/d470d6aa-f9f2-11e6-98f1-679f1e32af8f.gif)


Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.MdFarhanRaja:SearchableSpinner:1.9'
	}
  
Step 3. Inside JAVA

    public class MainActivity extends AppCompatActivity {
    ArrayList<String> items=new ArrayList<>();
    SpinnerDialog spinnerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selectedItems=(TextView)findViewById(R.id.txt);

        items.add("Mumbai");
        items.add("Delhi");
        items.add("Bengaluru");
        items.add("Hyderabad");
        items.add("Ahmedabad");
        items.add("Chennai");
        items.add("Kolkata");
        items.add("Surat");
        items.add("Pune");
        items.add("Jaipur");
        items.add("Lucknow");
        items.add("Kanpur");


        spinnerDialog=new SpinnerDialog(MainActivity.this,items,"Select or Search City","Close Button Text");// With No Animation
	spinnerDialog=new SpinnerDialog(MainActivity.this,items,"Select or Search City",R.style.DialogAnimations_SmileWindow,"Close Button Text");// With 	Animation
	
	
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this, item + "  " + position+"", Toast.LENGTH_SHORT).show();
                selectedItems.setText(item + " Position: " + position);
            }
        });
        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinerDialog();
            }
        });
    }
    }
    
Step 4. Add custom style in your styles.xml

	<style name="DialogAnimations" />
    	<style name="DialogAnimations.SmileWindow">
        <item name="android:windowEnterAnimation">@anim/slide_in_bottom</item>
        <item name="android:windowExitAnimation">@anim/slide_out_top</item>
    	</style>

  
