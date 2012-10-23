// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.*;
import android.util.*;
import com.android.internal.view.menu.MenuItemImpl;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.view:
//            ActionProvider, InflateException, Menu, MenuItem, 
//            View, SubMenu

public class MenuInflater {
    private class MenuState {

        private char getShortcut(String s) {
            char c = '\0';
            if(s != null)
                c = s.charAt(0);
            return c;
        }

        private Object newInstance(String s, Class aclass[], Object aobj[]) {
            Object obj1 = mContext.getClassLoader().loadClass(s).getConstructor(aclass).newInstance(aobj);
            Object obj = obj1;
_L2:
            return obj;
            Exception exception;
            exception;
            Log.w("MenuInflater", (new StringBuilder()).append("Cannot instantiate class: ").append(s).toString(), exception);
            obj = null;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private void setItem(MenuItem menuitem) {
            MenuItem menuitem1 = menuitem.setChecked(itemChecked).setVisible(itemVisible).setEnabled(itemEnabled);
            boolean flag;
            if(itemCheckable >= 1)
                flag = true;
            else
                flag = false;
            menuitem1.setCheckable(flag).setTitleCondensed(itemTitleCondensed).setIcon(itemIconResId).setAlphabeticShortcut(itemAlphabeticShortcut).setNumericShortcut(itemNumericShortcut);
            if(itemShowAsAction >= 0)
                menuitem.setShowAsAction(itemShowAsAction);
            if(itemListenerMethodName != null) {
                if(mContext.isRestricted())
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                menuitem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(mRealOwner, itemListenerMethodName));
            }
            if(menuitem instanceof MenuItemImpl) {
                MenuItemImpl menuitemimpl = (MenuItemImpl)menuitem;
                if(itemCheckable >= 2)
                    menuitemimpl.setExclusiveCheckable(true);
            }
            boolean flag1 = false;
            if(itemActionViewClassName != null) {
                menuitem.setActionView((View)newInstance(itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, mActionViewConstructorArguments));
                flag1 = true;
            }
            if(itemActionViewLayout > 0)
                if(!flag1)
                    menuitem.setActionView(itemActionViewLayout);
                else
                    Log.w("MenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            if(itemActionProvider != null)
                menuitem.setActionProvider(itemActionProvider);
        }

        public void addItem() {
            itemAdded = true;
            setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
        }

        public SubMenu addSubMenuItem() {
            itemAdded = true;
            SubMenu submenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            setItem(submenu.getItem());
            return submenu;
        }

        public boolean hasAddedItem() {
            return itemAdded;
        }

        public void readGroup(AttributeSet attributeset) {
            TypedArray typedarray = mContext.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuGroup);
            groupId = typedarray.getResourceId(1, 0);
            groupCategory = typedarray.getInt(3, 0);
            groupOrder = typedarray.getInt(4, 0);
            groupCheckable = typedarray.getInt(5, 0);
            groupVisible = typedarray.getBoolean(2, true);
            groupEnabled = typedarray.getBoolean(0, true);
            typedarray.recycle();
        }

        public void readItem(AttributeSet attributeset) {
            TypedArray typedarray = mContext.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuItem);
            itemId = typedarray.getResourceId(2, 0);
            int i = typedarray.getInt(5, groupCategory);
            int j = typedarray.getInt(6, groupOrder);
            itemCategoryOrder = 0xffff0000 & i | 0xffff & j;
            itemTitle = typedarray.getText(7);
            itemTitleCondensed = typedarray.getText(8);
            itemIconResId = typedarray.getResourceId(0, 0);
            itemAlphabeticShortcut = getShortcut(typedarray.getString(9));
            itemNumericShortcut = getShortcut(typedarray.getString(10));
            boolean flag;
            if(typedarray.hasValue(11)) {
                int k;
                if(typedarray.getBoolean(11, false))
                    k = 1;
                else
                    k = 0;
                itemCheckable = k;
            } else {
                itemCheckable = groupCheckable;
            }
            itemChecked = typedarray.getBoolean(3, false);
            itemVisible = typedarray.getBoolean(4, groupVisible);
            itemEnabled = typedarray.getBoolean(1, groupEnabled);
            itemShowAsAction = typedarray.getInt(13, -1);
            itemListenerMethodName = typedarray.getString(12);
            itemActionViewLayout = typedarray.getResourceId(14, 0);
            itemActionViewClassName = typedarray.getString(15);
            itemActionProviderClassName = typedarray.getString(16);
            if(itemActionProviderClassName != null)
                flag = true;
            else
                flag = false;
            if(flag && itemActionViewLayout == 0 && itemActionViewClassName == null) {
                itemActionProvider = (ActionProvider)newInstance(itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, mActionProviderConstructorArguments);
            } else {
                if(flag)
                    Log.w("MenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                itemActionProvider = null;
            }
            typedarray.recycle();
            itemAdded = false;
        }

        public void resetGroup() {
            groupId = 0;
            groupCategory = 0;
            groupOrder = 0;
            groupCheckable = 0;
            groupVisible = true;
            groupEnabled = true;
        }

        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        private ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;
        final MenuInflater this$0;


        public MenuState(Menu menu1) {
            this$0 = MenuInflater.this;
            super();
            menu = menu1;
            resetGroup();
        }
    }

    private static class InflatedOnMenuItemClickListener
        implements MenuItem.OnMenuItemClickListener {

        public boolean onMenuItemClick(MenuItem menuitem) {
            boolean flag = true;
            try {
                if(mMethod.getReturnType() == Boolean.TYPE) {
                    Method method1 = mMethod;
                    Object obj1 = mRealOwner;
                    Object aobj1[] = new Object[1];
                    aobj1[0] = menuitem;
                    flag = ((Boolean)method1.invoke(obj1, aobj1)).booleanValue();
                } else {
                    Method method = mMethod;
                    Object obj = mRealOwner;
                    Object aobj[] = new Object[1];
                    aobj[0] = menuitem;
                    method.invoke(obj, aobj);
                }
            }
            catch(Exception exception) {
                throw new RuntimeException(exception);
            }
            return flag;
        }

        private static final Class PARAM_TYPES[];
        private Method mMethod;
        private Object mRealOwner;

        static  {
            Class aclass[] = new Class[1];
            aclass[0] = android/view/MenuItem;
            PARAM_TYPES = aclass;
        }

        public InflatedOnMenuItemClickListener(Object obj, String s) {
            mRealOwner = obj;
            Class class1 = obj.getClass();
            try {
                mMethod = class1.getMethod(s, PARAM_TYPES);
                return;
            }
            catch(Exception exception) {
                InflateException inflateexception = new InflateException((new StringBuilder()).append("Couldn't resolve menu item onClick handler ").append(s).append(" in class ").append(class1.getName()).toString());
                inflateexception.initCause(exception);
                throw inflateexception;
            }
        }
    }


    public MenuInflater(Context context) {
        mContext = context;
        mRealOwner = context;
        Object aobj[] = new Object[1];
        aobj[0] = context;
        mActionViewConstructorArguments = aobj;
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    public MenuInflater(Context context, Object obj) {
        mContext = context;
        mRealOwner = obj;
        Object aobj[] = new Object[1];
        aobj[0] = context;
        mActionViewConstructorArguments = aobj;
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    private void parseMenu(XmlPullParser xmlpullparser, AttributeSet attributeset, Menu menu) throws XmlPullParserException, IOException {
        MenuState menustate;
        int i;
        boolean flag;
        String s;
        menustate = new MenuState(menu);
        i = xmlpullparser.getEventType();
        flag = false;
        s = null;
_L8:
        if(i != 2) goto _L2; else goto _L1
_L1:
        String s3 = xmlpullparser.getName();
        if(!s3.equals("menu")) goto _L4; else goto _L3
_L3:
        i = xmlpullparser.next();
_L7:
        boolean flag1 = false;
_L6:
        if(flag1)
            break MISSING_BLOCK_LABEL_363;
        switch(i) {
        default:
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_353;

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 3: // '\003'
            break;
        }
        break MISSING_BLOCK_LABEL_233;
_L9:
        i = xmlpullparser.next();
        if(true) goto _L6; else goto _L5
_L4:
        throw new RuntimeException((new StringBuilder()).append("Expecting menu, got ").append(s3).toString());
_L2:
        i = xmlpullparser.next();
        if(i != 1) goto _L8; else goto _L7
_L5:
        if(!flag) {
            String s2 = xmlpullparser.getName();
            if(s2.equals("group"))
                menustate.readGroup(attributeset);
            else
            if(s2.equals("item"))
                menustate.readItem(attributeset);
            else
            if(s2.equals("menu")) {
                parseMenu(xmlpullparser, attributeset, ((Menu) (menustate.addSubMenuItem())));
            } else {
                flag = true;
                s = s2;
            }
        }
          goto _L9
        String s1 = xmlpullparser.getName();
        if(flag && s1.equals(s)) {
            flag = false;
            s = null;
        } else
        if(s1.equals("group"))
            menustate.resetGroup();
        else
        if(s1.equals("item")) {
            if(!menustate.hasAddedItem())
                if(menustate.itemActionProvider != null && menustate.itemActionProvider.hasSubMenu())
                    menustate.addSubMenuItem();
                else
                    menustate.addItem();
        } else
        if(s1.equals("menu"))
            flag1 = true;
          goto _L9
        throw new RuntimeException("Unexpected end of document");
    }

    public void inflate(int i, Menu menu) {
        XmlResourceParser xmlresourceparser = null;
        xmlresourceparser = mContext.getResources().getLayout(i);
        parseMenu(xmlresourceparser, Xml.asAttributeSet(xmlresourceparser), menu);
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        return;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        throw new InflateException("Error inflating menu XML", xmlpullparserexception);
        Exception exception;
        exception;
        if(xmlresourceparser != null)
            xmlresourceparser.close();
        throw exception;
        IOException ioexception;
        ioexception;
        throw new InflateException("Error inflating menu XML", ioexception);
    }

    private static final Class ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE[];
    private static final Class ACTION_VIEW_CONSTRUCTOR_SIGNATURE[];
    private static final String LOG_TAG = "MenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object mActionProviderConstructorArguments[];
    private final Object mActionViewConstructorArguments[];
    private Context mContext;
    private Object mRealOwner;

    static  {
        Class aclass[] = new Class[1];
        aclass[0] = android/content/Context;
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = aclass;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    }






}
