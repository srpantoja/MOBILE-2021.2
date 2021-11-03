package com.example.intromobile

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import android.widget.Toast

import androidx.viewpager2.widget.ViewPager2
import com.example.intromobile.adapters.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //atv1ToggleButton()
        //atv2EditText()
        //
        //atv4AutoComplete()
        //atv5Spinner()
        //atv6RadioButton()
        //atv7MenuOptions()
        //atv8MenuDropDown()
        //atv9GoogleMaterial()
        //atv10LongPressedClick()
        //atv11Background()
        //atv12MultipleActivity()
        //atv13TabFragments()
        //atv14_15ListView_ArrayAdapter()
        atv17Som()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val _inflater: MenuInflater = menuInflater
        //_inflater.inflate(R.menu.option_menu_atv7, menu)
        //_inflater.inflate(R.menu.option_menu_atv8, menu)
        _inflater.inflate(R.menu.option_menu_atv9, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option1 -> Toast.makeText(this, "selecionou a opção 1", Toast.LENGTH_SHORT).show()
            R.id.option2 -> Toast.makeText(this, "selecionou a opção 2", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun atv1ToggleButton(){
        var _text : TextView
        var _toggleButton: ToggleButton
        setContentView(R.layout.atv1)
        _text = findViewById(R.id.textView)
        _toggleButton = findViewById(R.id.toggleButton)
        _toggleButton.setOnCheckedChangeListener {
            buttonView, isChecked -> isChecked
            _text.text = if(isChecked) "Ligado"
            else "Desligado"
        }
    }
    private fun atv2EditText(){
        var _inputText: EditText
        var _buttonSubmit: Button
        var _message: TextView

        setContentView(R.layout.atv2)
        _inputText = findViewById(R.id.edit_text_email)
        _buttonSubmit = findViewById(R.id.button_submit)
        _message = findViewById(R.id.message_email)

        _inputText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _buttonSubmit.isEnabled = android.util.Patterns.EMAIL_ADDRESS.matcher(_inputText.text.toString()).matches()
                if(!_buttonSubmit.isEnabled) {
                    _message.text = "Email inválido"
                    _message.setTextColor("#FFF44336".toColorInt())
                }else {
                    _message.text = "Email válido"
                    _message.setTextColor("#ff4cAf50".toColorInt())
                }
            }
        })
    }
    private fun atv4AutoComplete(){
    setContentView(R.layout.atv4)
        var _autoComplete : AutoCompleteTextView
        _autoComplete = findViewById(R.id.auto_complete)

        val sugestions = listOf("google", "apple", "samsung", "xiaomi", "huawei", "motorola", "LG", "Lenovo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sugestions)
        _autoComplete.threshold = 0
        _autoComplete.setAdapter(adapter)
        _autoComplete.setOnFocusChangeListener( {view , b -> if(b) _autoComplete.showDropDown()})
    }
    private fun atv5Spinner(){
        var _spinner: Spinner
        setContentView(R.layout.atv5)
        _spinner = findViewById(R.id.spinner)
        val dropdown = listOf("google", "apple", "samsung", "xiaomi", "huawei", "motorola", "LG", "Lenovo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dropdown)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        _spinner.adapter = adapter
        _spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                makeToast(_spinner)
            }

        }
    }
    private fun atv6RadioButton(){
        setContentView(R.layout.atv6)
        var _radioGroup : RadioGroup
        _radioGroup = findViewById(R.id.radioGroup)
        _radioGroup.setOnCheckedChangeListener({
            _radioGroup, i ->
            var _radioButton = findViewById<RadioButton>(i)
            if(_radioButton != null)
                Toast.makeText(this, "clicou na opção: " + _radioButton.text, Toast.LENGTH_SHORT).show()
        } )
    }
    private fun atv7MenuOptions() {
        setContentView(R.layout.atv7)
    }
    private fun atv8MenuDropDown(){
        setContentView(R.layout.atv8)
        val _text : TextView
        val _button : Button
        _text = findViewById(R.id.text_atv8)
        _button = findViewById(R.id.button_atv8)
        _button.setOnClickListener( fun(view) {
            val popup = PopupMenu(this, view)
            popup.inflate(R.menu.option_menu_atv8)

            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                item: MenuItem? ->
                when (item!!.itemId) {
                    R.id.dropdown1 ->  _text.text = item.title
                    R.id.dropdown2 ->  _text.text = item.title
                    R.id.dropdown3 ->  _text.text = item.title
                }
                true
            })
            popup.show()
        })
    }
    private fun atv9GoogleMaterial(){
        setContentView(R.layout.atv9)
        val _text : TextView
        val _button : Button
        _text = findViewById(R.id.text_material)
        _button = findViewById(R.id.button_material)
        _button.setOnClickListener( fun(view) {
            val popup = PopupMenu(this, view)
            popup.inflate(R.menu.option_menu_atv9)

            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                    item: MenuItem? ->
                when (item!!.itemId) {
                    R.id.option_1 ->  _text.text = item.title
                    R.id.option_2 ->  _text.text = item.title
                    R.id.option_3 ->  _text.text = item.title
                }
                true
            })
            popup.show()
        })

    }
    @SuppressLint("WrongConstant")
    private fun atv10LongPressedClick(){
        setContentView(R.layout.atv9)
        val _text : TextView
        val _button : Button
        _button = findViewById(R.id.button_material)
        _text = findViewById(R.id.text_material)
        _button.setOnLongClickListener { // TODO Auto-generated method stub
            _text.text = "long press"
            true
        }
        _button.setOnClickListener {
            _text.text = "short press"
            true
        }
    }
    private fun atv11Background(){
        setContentView(R.layout.atv11)
    }
    private fun atv12MultipleActivity(){
        setContentView(R.layout.atv12_a)
        val _button : Button
        _button = findViewById(R.id.button)
        _button.setOnClickListener {
            val intent = Intent(this, Activity12::class.java)
            startActivity(intent)
        }

    }
    private fun atv13TabFragments(){
        setContentView(R.layout.atv13)
        val _tabLayout : TabLayout
        val _viewPage2 : ViewPager2
        _tabLayout = findViewById(R.id.layout)
        _viewPage2 = findViewById(R.id.viewPager)

        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        _viewPage2.adapter = adapter

        TabLayoutMediator(_tabLayout,_viewPage2){ tab, position ->
            when(position) {
                0 -> {tab.text = "Dog"}
                1 -> {tab.text = "Cat"}
            }
        }.attach()


    }
    private fun atv3_14_15ListView_ArrayAdapter(){
        var _listView: ListView
        val list = listOf( "Brasil", "Argentina", "Uruguai", "Colombia" )
        setContentView(R.layout.atv3_14_15)
        _listView = findViewById(R.id.listView)
        _listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

    }
    private fun atv17Som(){
        setContentView(R.layout.atv17)
        val _sound : MediaPlayer
        val _btn : Button
        _btn = findViewById(R.id.button3)
        _sound = MediaPlayer.create(this, R.raw.som)
        _btn.setOnClickListener({
            _sound.start()
        })

    }
    private fun makeToast(spinner: Spinner){
        Toast.makeText(this, "clicou na opção: " + spinner.selectedItem, Toast.LENGTH_SHORT).show()

    }

}

