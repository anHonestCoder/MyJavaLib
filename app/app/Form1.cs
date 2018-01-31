using System;
using System.Configuration;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace app
{
    public partial class WinForm : Form
    {
        public WinForm()
        {
            InitializeComponent();
            this.initDictionay();
           
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void submit_button_click(object sender, EventArgs e)
        {

           string inputStr = this.inputText.Text;
           string[] inputArray = System.Text.RegularExpressions.Regex.Split(inputStr, @"\s+");

            //不带-的 dictionary
            Dictionary<String, int> itemDictionary = new Dictionary<string, int>();
            foreach (KeyValuePair<string, int> item in this.dictionary)
            {
                itemDictionary.Add(item.Key, item.Value);
            }

            //带-的dictionary
            Dictionary<String, int> secondDictionary = new Dictionary<string, int>();
            Dictionary<String, int>[] secondDictionaryArray = new Dictionary<string, int>[4];
            for (var i = 0; i < secondDictionaryArray.Length; i++)
            {
                secondDictionaryArray[i] = new Dictionary<string, int>();
            }

            foreach (var str in inputArray)
           {
                string tmp = str.Trim();
                if("".Equals(tmp))
                {
                    continue;
                }
                //不包含-的，直接跟数字
                if(!str.Contains("-"))
                {
                   Boolean isMatched = false;
                    for(int i = 0; i < itemDictionary.Count; i++) 
                    {
                        string key = itemDictionary.ElementAt(i).Key;
                        if (str.StartsWith(key))
                        {
                            isMatched = true;
                            string valueStr = str.Substring(key.Length);
                            int value = -1;
                            int.TryParse(valueStr, out value);
                            if(value == 0)
                            {
                                this.input_error(str, inputStr.IndexOf(str));
                               
                                return;
                            } else
                            {
                                itemDictionary[key] += value;
                            }
                        }
                    }
                    if(!isMatched)
                    {
                        this.input_error(str, inputStr.IndexOf(str));
                       
                        return;
                    }
                }
                else  //包含-
                {
                    
                    string[] strArray = System.Text.RegularExpressions.Regex.Split(tmp, "-");
                    if(strArray.Length != 2)
                    {
                        this.input_error(str, inputStr.IndexOf(str));
                        
                        return;
                    }

                    string keyStr = strArray[0];
                    string valueStr = strArray[1];

                    String regex1 = "^[1-6]{1,4}$";
                    String regex2 = "^[黑,红]{1}[1-6]{4}$";
                    
                    Boolean regexResult1 = System.Text.RegularExpressions.Regex.Match(keyStr, regex1).Success;
                    Boolean regexResult2 = false;
                    if(!regexResult1)
                    {
                        regexResult2 = System.Text.RegularExpressions.Regex.Match(keyStr, regex2).Success;
                    } 
                    if(!regexResult1 && !regexResult2)
                    {
                        this.input_error(str, inputStr.IndexOf(str));
                       
                        return;
                    }

                    int value = -1;
                    int.TryParse(valueStr, out value);
                    if (value == 0)
                    {
                        this.input_error(str, inputStr.IndexOf(str));
                        
                        return;
                    }
                   
                    if(keyStr.StartsWith("黑") || keyStr.StartsWith("红"))
                    {
                        if (secondDictionary.ContainsKey(keyStr))
                        {
                            secondDictionary[keyStr] += value;
                        }
                        else
                        {
                            secondDictionary.Add(keyStr, value);
                        }
                    } else {
                        for(var i = 0; i < secondDictionaryArray.Length; i++)
                        {
                            if(keyStr.Length == (i+1))
                            {
                                if (secondDictionaryArray[i].ContainsKey(keyStr))
                                {
                                    secondDictionaryArray[i][keyStr] += value;
                                }
                                else
                                {
                                    secondDictionaryArray[i].Add(keyStr, value);
                                }
                            }
                        }
                    }


                }
           }

            string result = "";
            foreach(var dic in itemDictionary)
            {
                if(dic.Value != 0)
                {
                    
                    result = result + dic.Key + dic.Value;
                    result += "  ";
                }
                              
            }
            result += "\r\n";

            for(var i = 0; i < secondDictionaryArray.Length; i++)
            {
                Dictionary<String, int> tmpDic = secondDictionaryArray[i];
                foreach (var dic in tmpDic)
                {
                    if (dic.Value != 0)
                    {

                        result = result + dic.Key + "-" + dic.Value;
                        result += "  ";
                    }
                }
            }

            foreach (var dic in secondDictionary)
            {
                if (dic.Value != 0)
                {

                    result = result + dic.Key + "-" + dic.Value;
                    result += "  ";
                }
            }

           // string lineSliper = this.resultText.Text + "\r\n" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \r\n";
            this.resultText.Text = "汇总后数据：\r\n" + result ;
        }

        //输入有误处理方法
        private void input_error(string input, int index)
        {
            MessageBox.Show("【" + input + "】输入有误，请检查输入!");
            this.inputText.SelectionStart = index+input.Length;
            this.inputText.Focus();
        }


        private void clear_button_click(object sender, EventArgs e)
        {
            inputText.Text = "";
            resultText.Text = "";
        }



        private void clearResult_Click(object sender, EventArgs e)
        {
            this.resultText.Text = "";
        }

      

        private void inputText_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == System.Windows.Forms.MouseButtons.Right)
            {
                
                ContextMenu contextMenu1 = new System.Windows.Forms.ContextMenu();

                MenuItem menuItem =  new MenuItem("复制");
                menuItem.Click += new EventHandler(CopyAction);
                contextMenu1.MenuItems.Add(menuItem);
                menuItem = new MenuItem("粘贴");
                menuItem.Click += new EventHandler(PasteAction);
                contextMenu1.MenuItems.Add(menuItem);
               
                inputText.ContextMenu = contextMenu1;
            }

        }

        private void resultText_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == System.Windows.Forms.MouseButtons.Right)
            {

                ContextMenu contextMenu = new System.Windows.Forms.ContextMenu();

                MenuItem menuItem = new MenuItem("复制");
                menuItem.Click += new EventHandler(CopyAction);
                contextMenu.MenuItems.Add(menuItem);
               
                
                
                resultText.ContextMenu = contextMenu;
            }

        }

        void ClearAction(object sender, EventArgs e)
        {
            RichTextBox textBox = ((sender as MenuItem).Parent as ContextMenu).SourceControl as RichTextBox;
            textBox.Text = "";
        }

        void CutAction(object sender, EventArgs e)
        {

            RichTextBox textBox = ((sender as MenuItem).Parent as ContextMenu).SourceControl as RichTextBox;
            Clipboard.SetData(DataFormats.Rtf, textBox.SelectedRtf);//复制RTF数据到剪贴板
            textBox.SelectedRtf = "";//再把当前选取的RTF内容清除掉,当前就实现剪切功能了.
        }

        void CopyAction(object sender, EventArgs e)
        {
            RichTextBox textBox = ((sender as MenuItem).Parent as ContextMenu).SourceControl as RichTextBox;
            Clipboard.SetText(textBox.SelectedText);
        }

        void PasteAction(object sender, EventArgs e)
        {
            RichTextBox textBox = ((sender as MenuItem).Parent as ContextMenu).SourceControl as RichTextBox;
            textBox.Paste();//把剪贴板上的数据粘贴到目标RichTextBox
        }

    }
}
