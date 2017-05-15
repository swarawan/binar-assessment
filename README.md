# Binar Assessment Test
Rio Swarawan


###Jawaban:

1. Relative Layout
2. File `AndroidManifest.xml`
3. Lifecycle-nya adalah sebagai berikut

	```
	A.OnCreate() - A.OnStart() - A.OnResume() - A.OnPause() - A.OnStop() - 
	B.OnCreate() - B.OnStart() - B.OnResume()
	```
4. Menggunakan class Intent, pertama yang harus dilakukan adalah meng-instansiasi kelas Intent. Kedua, deklarasikan intent akan dijalankan dari activity mana ke activity mana. Ketiga, jalankan intent menggunakan method `startActivity(intent)`. Berikut sample code-nya:

	```
	Intent intent = new Intent(ActivityA.this, Activity.class);
	
	startActivity(intent);
	```

5. Activity di destroy, artinya memanggil method `finish()` dan Activity tidak akan hanya pause, tetapi lanjut hinggal ke `onStop()` dan `onDestroy()`. Dan didalam method `onPause()` terdapat method `isFinishing()` dimana method tersebut akan dipanggil oleh `finish()`. Jadi jawaban yang tepat adalah:

	```
Seharusnya akan memunculkan Toast bertuliskan Finishing, tetapi karena tidak ada 
method show() yang dijalankan oleh Toast, maka tidak akan memunculkan 
apa-apa di UI Thread.
	```

6. Tag `<uses-permissions ... />` seharusnya ada diluar tag `<application>`. Berikut hasil yang benar:

	```
	<? xml version= "1.0"  encoding= "utf-8" ?>
	<manifest  ...>
		<uses-permission  android :name= "android.permission.CALL_USER"  />
			
		<application ...>
		</application > 
	</ manifest >
	```
	
7. Anagram

	```
	private boolean anagram(String text) {
        for (int position = 0; position < text.length(); position++) {
            if(position == (position+1)) break;
            if (text.toLowerCase().charAt(position) != text.toLowerCase().charAt(text.length() - (position + 1)))
                return false;
        }
        return true;
    }
	```
	
8.	Menghilangkan duplikasi karakter

	```
	private static String removeDuplicates(String text) {
        String result = "";
        for (int position = 0; position < text.length(); position++) {
            if(position == text.length()-1) 
                result = result += text.charAt(position);
            else if (text.charAt(position) != text.charAt(position + 1))
                result = result += text.charAt(position);
        }
        return result;
    }
    ```
  
