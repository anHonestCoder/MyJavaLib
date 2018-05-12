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
using System.Runtime.InteropServices;

namespace app
{
    public partial class WinForm : Form
    {

        #region 窗体边框阴影动画效果移动改变大小
        const int CS_DropSHADOW = 0x20000;
        const int GCL_STYLE = (-26);
        //声明Win32 API
        [DllImport("user32.dll", CharSet = CharSet.Auto)]
        public static extern int SetClassLong(IntPtr hwnd, int nIndex, int dwNewLong);
        [DllImport("user32.dll", CharSet = CharSet.Auto)]
        public static extern int GetClassLong(IntPtr hwnd, int nIndex);

        [DllImport("user32")]
        private static extern bool AnimateWindow(IntPtr hwnd, int dwTime, int dwFlags);

        /*

         * 函数功能：该函数能在显示与隐藏窗口时能产生特殊的效果。有两种类型的动画效果：滚动动画和滑动动画。

         * 函数原型：BOOL AnimateWindow（HWND hWnd，DWORD dwTime，DWORD dwFlags）；

         * hWnd：指定产生动画的窗口的句柄。

         * dwTime：指明动画持续的时间（以微秒计），完成一个动画的标准时间为200微秒。

         * dwFags：指定动画类型。这个参数可以是一个或多个下列标志的组合。

         * 返回值：如果函数成功，返回值为非零；如果函数失败，返回值为零。

         * 在下列情况下函数将失败：窗口使用了窗口边界；窗口已经可见仍要显示窗口；窗口已经隐藏仍要隐藏窗口。若想获得更多错误信息，请调用GetLastError函数。

         * 备注：可以将AW_HOR_POSITIVE或AW_HOR_NEGTVE与AW_VER_POSITVE或AW_VER_NEGATIVE组合来激活一个窗口。

         * 可能需要在该窗口的窗口过程和它的子窗口的窗口过程中处理WM_PRINT或WM_PRINTCLIENT消息。对话框，控制，及共用控制已处理WM_PRINTCLIENT消息，缺省窗口过程也已处理WM_PRINT消息。

         * 速查：WIDdOWS NT：5.0以上版本：Windows：98以上版本；Windows CE：不支持；头文件：Winuser.h；库文件：user32.lib。

         */

        //标志描述：

        public const int AW_SLIDE = 0x40000;//使用滑动类型。缺省则为滚动动画类型。当使用AW_CENTER标志时，这个标志就被忽略。

        public const int AW_ACTIVATE = 0x20000;//激活窗口。在使用了AW_HIDE标志后不要使用这个标志。

        public const int AW_BLEND = 0x80000;//使用淡出效果。只有当hWnd为顶层窗口的时候才可以使用此标志。

        public const int AW_HIDE = 0x10000;//隐藏窗口，缺省则显示窗口。(关闭窗口用)

        public const int AW_CENTER = 0x0010;//若使用了AW_HIDE标志，则使窗口向内重叠；若未使用AW_HIDE标志，则使窗口向外扩展。

        public const int AW_HOR_POSITIVE = 0x0001;//自左向右显示窗口。该标志可以在滚动动画和滑动动画中使用。当使用AW_CENTER标志时，该标志将被忽略。

        public const int AW_VER_POSITIVE = 0x0004;//自顶向下显示窗口。该标志可以在滚动动画和滑动动画中使用。当使用AW_CENTER标志时，该标志将被忽略。

        public const int AW_HOR_NEGATIVE = 0x0002;//自右向左显示窗口。该标志可以在滚动动画和滑动动画中使用。当使用AW_CENTER标志时，该标志将被忽略。

        public const int AW_VER_NEGATIVE = 0x0008;//自下向上显示窗口。该标志可以在滚动动画和滑动动画中使用。当使用AW_CENTER标志时，该标志将被忽略。
        //需添加using System.Runtime.InteropServices
        [DllImport("user32.dll")]

        public static extern bool ReleaseCapture();

        [DllImport("user32.dll")]

        public static extern bool SendMessage(IntPtr hwnd, int wMsg, int wParam, int lParam);

        //常量

        public const int WM_SYSCOMMAND = 0x0112;

        //窗体移动

        public const int SC_MOVE = 0xF010;

        public const int HTCAPTION = 0x0002;

        //改变窗体大小
        public const int WMSZ_LEFT = 0xF001;

        public const int WMSZ_RIGHT = 0xF002;

        public const int WMSZ_TOP = 0xF003;

        public const int WMSZ_TOPLEFT = 0xF004;

        public const int WMSZ_TOPRIGHT = 0xF005;

        public const int WMSZ_BOTTOM = 0xF006;

        public const int WMSZ_BOTTOMLEFT = 0xF007;

        public const int WMSZ_BOTTOMRIGHT = 0xF008;
        #endregion

        public WinForm()
        {
            InitializeComponent();
            this.initDictionay();
            SetClassLong(this.Handle, GCL_STYLE, GetClassLong(this.Handle, GCL_STYLE) | CS_DropSHADOW); //API函数加载，实现窗体边框阴影效果

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //窗体加载动画效果
            //AnimateWindow(this.Handle, 500, AW_BLEND | AW_CENTER);
        }

        /// <summary>
        /// 获取游标位置并改变形状
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            Point p = this.PointToClient(MousePosition);
            int xx = Width;
            int yy = Height;
            //TopLeft
            if (p.X <= 2 && p.Y <= 2)
            {
                this.Cursor = Cursors.SizeNWSE;
                wParam = (new IntPtr(WMSZ_TOPLEFT)).ToInt32();
            }
            //TopRight
            else if (p.X >= Width - 2 && p.Y <= 2)
            {
                this.Cursor = Cursors.SizeNESW;
                wParam = (new IntPtr(WMSZ_TOPRIGHT)).ToInt32();
            }
            //BottomLeft
            else if (p.X <= 2 && p.Y >= Height - 2)
            {
                this.Cursor = Cursors.SizeNESW;
                wParam = (new IntPtr(WMSZ_BOTTOMLEFT)).ToInt32();
            }
            //BottomRight
            else if (p.X >= Width - 2 && p.Y >= Height - 2)
            {
                this.Cursor = Cursors.SizeNWSE;
                wParam = (new IntPtr(WMSZ_BOTTOMRIGHT)).ToInt32();
            }
            //Left
            else if (p.Y > 2 && p.Y < Height - 2 && p.X < 2)
            {
                this.Cursor = Cursors.SizeWE;
                wParam = (new IntPtr(WMSZ_LEFT)).ToInt32();
            }
            //Up
            else if (p.X > 2 && p.X < Width - 2 && p.Y < 2)
            {
                this.Cursor = Cursors.SizeNS;
                wParam = (new IntPtr(WMSZ_TOP)).ToInt32();
            }
            //Bottom
            else if (p.X > 2 && p.X < Width - 2 && p.Y > Height - 2)
            {
                this.Cursor = Cursors.SizeNS;
                wParam = (new IntPtr(WMSZ_BOTTOM)).ToInt32();
            }
            //Right
            else if (p.Y > 2 && p.Y < Height - 2 && p.X > Width - 2)
            {
                this.Cursor = Cursors.SizeWE;
                wParam = (new IntPtr(WMSZ_RIGHT)).ToInt32();
            }
            else
                this.Cursor = Cursors.Default;


        }

        private int wParam = 0;
        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {
            Point p = this.PointToClient(MousePosition);
            //Move
            if (p.X > 2 && p.X < Width - 2 && p.Y > 2 && p.Y < Height - 2)
            {
                ReleaseCapture();
                SendMessage(this.Handle, WM_SYSCOMMAND, SC_MOVE + HTCAPTION, 0);
            }
            else // ChangeSize
            {

                ReleaseCapture();
                SendMessage(this.Handle, WM_SYSCOMMAND, wParam, IntPtr.Zero.ToInt32());

            }
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
                            break;
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

        private void groupBox3_Enter(object sender, EventArgs e)
        {

        }
    }
}
